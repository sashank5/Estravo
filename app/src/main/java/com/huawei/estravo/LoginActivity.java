/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;

public class LoginActivity extends AppCompatActivity {
	private AccountAuthService mAuthService;
	private AccountAuthParams mAuthParam;
	private static final int REQUEST_CODE_SIGN_IN = 1000;
	private static final String TAG = "Account";
	private TextView logText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_huawei_login);

		findViewById(R.id.HuaweiIdAuthButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				silentSignInByHwId();
			}
		});
		findViewById(R.id.HuaweiIdSignOutButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				signOut();
			}
		});

		findViewById(R.id.HuaweiIdCancelAuthButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cancelAuthorization();
			}
		});
		logText = findViewById(R.id.log);

	}

	public void silentSignInByHwId() {

		mAuthParam = new AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
				.setEmail()
				.createParams();

		mAuthService = AccountAuthManager.getService(this, mAuthParam);


		Task<AuthAccount> task = mAuthService.silentSignIn();
		task.addOnSuccessListener(new OnSuccessListener<AuthAccount>() {
			@Override
			public void onSuccess(AuthAccount authAccount) {

				showLog("silent sign in success");
				dealWithResultOfSignIn(authAccount);

			}
		});
		task.addOnFailureListener(new OnFailureListener() {
			@Override
			public void onFailure(Exception e) {

				if (e instanceof ApiException) {
					ApiException apiException = (ApiException) e;
					Intent signInIntent = mAuthService.getSignInIntent();
					startActivityForResult(signInIntent, REQUEST_CODE_SIGN_IN);
				}
			}
		});
	}
	public void skip(View view){
		Intent intent = new Intent(this,DashBoard.class);
		startActivity(intent);
	}
	public void dealWithResultOfSignIn(AuthAccount authAccount) {
		Intent intent = new Intent(this,DashBoard.class);
		String User_name = authAccount.getDisplayName();
		String Email = authAccount.getEmail();
		intent.putExtra("User_name",User_name);
		intent.putExtra("Email",Email);
		startActivity(intent);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_SIGN_IN) {
			Log.i(TAG, "onActivitResult of sigInInIntent, request code: " + REQUEST_CODE_SIGN_IN);
			Task<AuthAccount> authAccountTask = AccountAuthManager.parseAuthResultFromIntent(data);
			if (authAccountTask.isSuccessful()) {
				showLog("sign in success");
				AuthAccount authAccount = authAccountTask.getResult();
				dealWithResultOfSignIn(authAccount);
				Log.i(TAG, "onActivitResult of sigInInIntent, request code: " + REQUEST_CODE_SIGN_IN);

			} else {

				showLog("sign in failed : " + ((ApiException) authAccountTask.getException()).getStatusCode());
				Log.e(TAG, "sign in failed : " + ((ApiException) authAccountTask.getException()).getStatusCode());
			}
		}


	}

	public void signOut() {
		if (mAuthService == null) {
			return;
		}
		Task<Void> signOutTask = mAuthService.signOut();
		signOutTask.addOnSuccessListener(new OnSuccessListener<Void>() {
			@Override
			public void onSuccess(Void aVoid) {
				Log.i(TAG, "SignOut Success");
				showLog("SignOut Success");
			}
		}).addOnFailureListener(new OnFailureListener() {
			@Override
			public void onFailure(Exception e) {
				Log.i(TAG, "SignOut fail");
				showLog("SignOut fail");
			}
		});
	}

	private void cancelAuthorization() {
		if (mAuthService == null) {
			return;
		}
		Task<Void> task = mAuthService.cancelAuthorization();
		task.addOnSuccessListener(new OnSuccessListener<Void>() {
			@Override
			public void onSuccess(Void aVoid) {
				Log.i(TAG, "cancelAuthorization success");
				showLog("cancelAuthorization success");
			}
		});
		task.addOnFailureListener(new OnFailureListener() {
			@Override
			public void onFailure(Exception e) {
				Log.i(TAG, "cancelAuthorization failure：" + e.getClass().getSimpleName());
				showLog("cancelAuthorization failure：" + e.getClass().getSimpleName());
			}
		});
	}

	private void showLog(String log) {

		logText.setText("log:" + "\n" + log);

	}


}

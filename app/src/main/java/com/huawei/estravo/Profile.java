package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.support.account.result.AuthAccount;


public class Profile extends AppCompatActivity {
    int RESULT_LOAD_IMAGE = 1;
    AuthAccount authAccount=new AuthAccount();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String User_name=authAccount.getDisplayName();
        String Email = authAccount.getEmail();

        TextView user_name = findViewById(R.id.user_name);
        user_name.setText("User Name: " + User_name);
        TextView email = findViewById(R.id.email);
        email.setText("Email Address: " + Email);

    }
    public void back(View view){
        onBackPressed();
    }
    public void dashboard(View view){
        Intent intent = new Intent(Profile.this,DashBoard.class);
        startActivity(intent);
    }
    public void profilepic(View view) {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = findViewById(R.id.profilepic);
            imageView.setImageURI(selectedImage);
        }
    }

}
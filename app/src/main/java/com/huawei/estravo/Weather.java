package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.kit.awareness.Awareness;
import com.huawei.hms.kit.awareness.capture.WeatherStatusResponse;
import com.huawei.hms.kit.awareness.status.WeatherStatus;
import com.huawei.hms.kit.awareness.status.weather.Situation;
import com.huawei.hms.kit.awareness.status.weather.WeatherSituation;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Weather extends AppCompatActivity {
    Context context;
    TextView city, temp, windspeed, winddir, humidity, Weather,realtemp,Pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Weather = findViewById(R.id.Weather);
        Weather.setText("Weather");


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Awareness.getCaptureClient(this).getWeatherByDevice()

                    .addOnSuccessListener(new OnSuccessListener<WeatherStatusResponse>() {
                        @Override
                        public void onSuccess(WeatherStatusResponse weatherStatusResponse) {
                            WeatherStatus weatherStatus = weatherStatusResponse.getWeatherStatus();
                            WeatherSituation weatherSituation = weatherStatus.getWeatherSituation();
                            Situation situation = weatherSituation.getSituation();
                            String place = weatherSituation.getCity().getName();
                            String temperature = situation.getTemperatureC() + "°C";
                            String wind_speed = situation.getWindSpeed() + " km/h";
                            String wind_dir = situation.getWindDir();
                            String Humidity = situation.getHumidity() + " %";
                            String real_temp = situation.getRealFeelC() + "°C";
                            String pressure = situation.getPressure() + "mm Hg";
                            city = findViewById(R.id.city_name);
                            temp = findViewById(R.id.temperature);
                            winddir = findViewById(R.id.winddir);
                            windspeed = findViewById(R.id.windspeed);
                            humidity = findViewById(R.id.humidity);
                            realtemp = findViewById(R.id.real_temp);
                            Pressure = findViewById(R.id.pressure);
                            city.setText(place);
                            temp.setText(temperature);
                            windspeed.setText(wind_speed);
                            winddir.setText(wind_dir);
                            humidity.setText(Humidity);
                            realtemp.setText(real_temp);
                            Pressure.setText(pressure);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {

                        }

                    });
        }




    }
    public void back(View view){
        onBackPressed();
    }
    public void home(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
    public void go_profile(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
}
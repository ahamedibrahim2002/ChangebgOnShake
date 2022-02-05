package com.example.changebgcolorshake;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    RelativeLayout layout;
    Sensor sensor;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        layout=findViewById(R.id.main);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor,int accuracy){}

    @Override
    public void onSensorChanged(SensorEvent event){
        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];

        float value=(x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(value >=2.0f) {
            double random = Math.ceil(Math.random() * 10);
            if (random == 1)
                layout.setBackgroundColor(Color.BLUE);
            if (random == 2)
                layout.setBackgroundColor(Color.WHITE);
            if (random == 3)
                layout.setBackgroundColor(Color.CYAN);
        }
    }


}

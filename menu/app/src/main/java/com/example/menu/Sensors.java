package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Sensors extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        acceleration = (TextView)findViewById(R.id.acceleration);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        acceleration.setText("X: "+sensorEvent.values[0] +"\nY: "+sensorEvent.values[1]+ "\nZ: "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exampe_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                openActivity2();
                return true;
            case R.id.item4:
                savedataActivity();
            case R.id.item5:
                sensorActivity();
            case R.id.item2:
                openDialog();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Sub Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openActivity2() {
        Intent intent = new Intent(this, activity2.class);
        startActivity(intent);
    }

    public void savedataActivity() {
        Intent intent = new Intent(this, savedata.class);
        startActivity(intent);
    }
    public void sensorActivity() {
        Intent intent = new Intent(this, Sensors.class);
        startActivity(intent);
    }
    public void openDialog() {
        Ex exampleDialog = new Ex();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}

package com.example.prasakul.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.adefruandta.spinningwheel.SpinningWheelView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class spinnerActivity extends AppCompatActivity {
    SpinningWheelView wheelView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        wheelView = (SpinningWheelView) findViewById(R.id.wheel);
        // Can be array string or list of object
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);


        List<String> list =new ArrayList<String>();
        Collections.addAll(list, message.split(","));

        wheelView.setItems(list);

        // Set listener for rotation event
        wheelView.setOnRotationListener(new SpinningWheelView.OnRotationListener<String>() {
            // Call once when start rotation
            @Override
            public void onRotation() {
                Log.d("XXXX", "On Rotation");
            }

            // Call once when stop rotation
            @Override
            public void onStopRotation(String item) {
                Log.d("XXXX", "On Rotation");
                new AlertDialog.Builder(spinnerActivity.this).setMessage(item).create().show();
            }
        });

        // If true: user can rotate by touch
        // If false: user can not rotate by touch
        wheelView.setEnabled(false);

    }

    public void spinWheel(View view) {
        // Do something in response to button
        // max angle 50
        // duration 10 second
        // every 50 ms rander rotation
        wheelView.rotate((float) (Math.random()*90), 3000, 10);
    }
}

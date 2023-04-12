package com.example.practical_1_013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Notified extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notified);
        Toast.makeText(this, "This is your message", Toast.LENGTH_LONG).show();
    }
}
package com.saravanan.jokeactivitylib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView tvJokes;
    String receiveJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        tvJokes = (TextView) findViewById(R.id.tcJokesValue);
        receiveJoke = getIntent().getStringExtra("jokes");
        tvJokes.setText(receiveJoke);
    }
}

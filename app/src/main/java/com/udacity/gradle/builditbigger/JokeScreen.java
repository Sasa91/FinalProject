package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeScreen extends Activity {

    TextView tvJokeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_details);

        tvJokeDisplay = (TextView) findViewById(R.id.tvDisplayJoke);


        String jokeResult = getIntent().getStringExtra("jokeresult");


        tvJokeDisplay.setText(jokeResult);


    }
}

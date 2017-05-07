package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.saravanan.finalproject.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class JokeTask extends AsyncTask<Void, Void, String> {

    private MyApi myApiService = null;

    private JokeTask.Callback callback;

    public interface Callback{
        void onFinished(String result);
    }

    public JokeTask(JokeTask.Callback callback){
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://finalproject-166317.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.getJokes().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(final String s) {

        if(s != null){
            callback.onFinished(s);
        }

    }
}

package com.udacity.gradle.builditbigger;

import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.concurrent.ExecutionException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button tellJokeBtn;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        tellJokeBtn = (Button) root.findViewById(R.id.btnTellJoke);


        if(com.udacity.gradle.builditbigger.BuildConfig.Paid_Version == true){

         //Do Nothing

        }else{
            
            AdView mAdView = (AdView) root.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);

        }

        tellJokeBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                // Perform action on click

                JokeTask testJoke = new JokeTask(new JokeTask.Callback() {
                    @Override
                    public void onFinished(String result) {

                    }
                });
                testJoke.execute();
                try {
                    String joke = testJoke.get();
                    startJokeActivity(joke);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        });



        return root;
    }

    public void startJokeActivity(String result){

        Intent startJokeActivity = new Intent(getActivity(), JokeScreen.class);
        startJokeActivity.putExtra("jokeresult",result);
        startActivity(startJokeActivity);

    }





}

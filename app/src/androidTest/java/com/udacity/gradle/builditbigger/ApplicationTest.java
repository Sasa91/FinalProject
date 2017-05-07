package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by DELL on 5/7/2017.
 */

public class ApplicationTest  extends ApplicationTestCase<Application> {
    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    public ApplicationTest() {
        super(Application.class);
    }
    public void testFetchJokeTask() throws ExecutionException, InterruptedException {
        JokeTask testJoke = new JokeTask(new JokeTask.Callback() {
            @Override
            public void onFinished(String result) {

            }
        });
        testJoke.execute();
        String joke = testJoke.get();
        assertNotNull(joke);
    }
}

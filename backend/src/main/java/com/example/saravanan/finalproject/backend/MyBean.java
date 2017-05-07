package com.example.saravanan.finalproject.backend;

import com.example.Jokes;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;
    private String jokes;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public void setJoke(String joke){
        jokes =  joke;
    }

    public String getJoke(){

    return  jokes;
    }


}
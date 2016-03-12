package com.firebase.myfirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by HP LAPTOP on 11-03-2016.
 */
public class FireBaseWeather extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

package com.prudhvi.fuzzsimpleapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by prudhvi on 4/11/2015.
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}

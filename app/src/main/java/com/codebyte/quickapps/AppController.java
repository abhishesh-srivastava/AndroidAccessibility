package com.codebyte.quickapps;

import android.app.Application;
import android.util.SparseArray;

import com.codebyte.quickapps.models.AppInfo;
import com.codebyte.quickapps.util.GlobalConstants;

/**
 * Created by abhishesh.s on 02/07/17.
 */

public class AppController extends Application {

    private static AppController sInstance;

    public AppController() {
        sInstance = this;
    }

    public static AppController getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

}

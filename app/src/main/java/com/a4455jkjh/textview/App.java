package com.a4455jkjh.textview;

import android.app.Application;

import com.a4455jkjh.view.EditorSettings;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EditorSettings.init(this);
    }
}

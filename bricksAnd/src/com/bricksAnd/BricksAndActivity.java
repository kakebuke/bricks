package com.bricksAnd;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.bricks.Bricks;

import android.app.Activity;
import android.os.Bundle;

public class BricksAndActivity extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Bricks(), true);
    }
}
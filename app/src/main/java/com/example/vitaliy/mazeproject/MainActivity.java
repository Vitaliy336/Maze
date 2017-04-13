package com.example.vitaliy.mazeproject;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private MazeView view;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(MainActivity.class.getName(), "Title");
        GameManager gameManager = new GameManager();
        view = new MazeView(this,gameManager);

        gestureDetector = new GestureDetector(this, gameManager);
        setContentView(view);
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPresitentState){
        super.onSaveInstanceState(outState, outPresitentState);
        outState.putString("Title", "Hello");
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        return gestureDetector.onTouchEvent(event);
    }
}

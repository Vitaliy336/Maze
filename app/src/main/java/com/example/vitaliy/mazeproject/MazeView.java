package com.example.vitaliy.mazeproject;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vitaliy on 4/12/17.
 */

public class MazeView extends View {
    private GameManager gameManager;

    public MazeView(Context context){
        super(context);
    }

    public MazeView(Context context, AttributeSet attr){
        super(context, attr);
    }

    public MazeView(Context context, GameManager gameManager){
        super(context);
        this.gameManager = gameManager;
        gameManager.setView(this);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        gameManager.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        gameManager.setScreenSize(w,h);
    }

}

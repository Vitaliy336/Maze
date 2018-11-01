package com.example.vitaliy.mazeproject;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by vitaliy on 4/12/17.
 */

public class Dot implements Drawable{
    private final int size;
    protected final Point point;
    protected final Paint paint;

    public Dot(int size, Point point, Paint paint) {
        this.size = size;
        this.point = point;
        this.paint = paint;
    }

    public Point getPoint(){
        return point;
    }
    @Override
    public void draw(Canvas canvas, Rect rect){
        float cellSize = (float)(rect.right - rect.left) / size;
        canvas.drawRect(rect.left + point.x * cellSize,
                rect.top + point.y * cellSize,
                rect.left + point.x * cellSize + cellSize,
                rect.top + point.y * cellSize + cellSize,
                paint);
    }
}

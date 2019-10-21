package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyPaint extends View {

    MyPaint(Context context) {
        super(context);
    }
    Paint paint = new Paint();
    float x = 0;
    long lastTime = System.currentTimeMillis();
    @Override

    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, 300, 20, paint);
        long nowTime = System.currentTimeMillis();
        x += 0.9f * (nowTime - lastTime);
        lastTime = nowTime;
        invalidate();
    }
}

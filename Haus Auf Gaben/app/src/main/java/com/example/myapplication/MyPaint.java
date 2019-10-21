package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyPaint extends View {

    MyPaint(Context context) {
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(300, 300, 200, paint);
    }
}

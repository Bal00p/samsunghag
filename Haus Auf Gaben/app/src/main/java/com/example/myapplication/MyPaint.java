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
        int y=0;
        while (y<canvas.getHeight()*2){
            canvas.drawLine(canvas.getWidth()-y,0,canvas.getWidth(),y,paint);
            y+=30;
        }
    }
}

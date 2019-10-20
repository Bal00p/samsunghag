package com.example.fotitschool;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyDraw extends View {

    MyDraw(Context context) {
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int y = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y += 30;
        }
    }
}

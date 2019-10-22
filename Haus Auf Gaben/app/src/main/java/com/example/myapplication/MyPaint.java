package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

@SuppressLint("DrawAllocation")
public class MyPaint extends View {
    int N = 8;
    int[] x = new int[N];
    int[] y = new int[N];
    int[] vx = new int[N];
    int[] vy = new int[N];
    int[] L = new int[N];
    int[] Red = new int[N];
    int[] Green = new int[N];
    int[] Blue = new int[N];
    int[] R = new int[N];
    int z = -1;
    double a = 0, ha = Math.PI / 180;

    void fillArrayRandom(int[] a, int min, int max) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
    }

    void makeBalls() {
        fillArrayRandom(x, 50, 250);
        fillArrayRandom(y, 50, 250);
        fillArrayRandom(vx, -50, 100);
        fillArrayRandom(vy, -50, 100);
        fillArrayRandom(L, 3, 10);
        fillArrayRandom(Red, 50, 255);
        fillArrayRandom(Green, 50, 255);
        fillArrayRandom(Blue, 50, 255);
        fillArrayRandom(R, 20, 40);
    }

    void moveBalls() {
        for (int i = 0; i < N; i++) {
                x[i] = this.getWidth() / 2 + (int) ((i+1)*100 * Math.cos(a/(i+1)));
                y[i] = this.getHeight() / 2 + (int) ((i+1)*100 * Math.sin(a/(i+1)));
        }
        a = a + ha;
    }

    MyPaint(Context context) {
        super(context);
        makeBalls();
        MyTimer timer = new MyTimer();
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //sun
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(this.getWidth() / 2, this.getHeight() / 2, 70, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("SUN",this.getWidth()/2, this.getHeight()/2,paint);
        //mercury
        paint.setColor(Color.argb(255,217,255,178));
        canvas.drawCircle(x[0], y[0], 20, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("MERCURY",x[0]+10, y[0]-15,paint);
        //venus
        paint.setColor(Color.argb(200,176,24,1));
        canvas.drawCircle(x[1], y[1], 30, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("VENUS",x[1]+10, y[1]-15,paint);
        //earth
        paint.setColor(Color.argb(255,12,23,255));
        canvas.drawCircle(x[2], y[2], 35, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("EARTH",x[2]+10, y[2]-15,paint);
        //mars
        paint.setColor(Color.argb(255,255,174,127));
        canvas.drawCircle(x[3], y[3], 25, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("MARS",x[3]+10, y[3]-15,paint);
        //jupiter
        paint.setColor(Color.argb(255,255,230,142));
        canvas.drawCircle(x[4], y[4], 65, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("JUPITER",x[4]+10, y[4]-15,paint);
        //saturn
        paint.setColor(Color.argb(255,255,230,50));
        canvas.drawCircle(x[5], y[5], 40, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("SATURN",x[5]+10, y[5]-15,paint);
        //uranus
        paint.setColor(Color.argb(255,121,175,255));
        canvas.drawCircle(x[6], y[6], 40, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("URANUS",x[6]+10, y[6]-15,paint);
        //neptune
        paint.setColor(Color.argb(255,147,255,254));
        canvas.drawCircle(x[7], y[7], 35, paint);
        paint.setTextSize(30.0f);
        paint.setColor(Color.BLACK);
        canvas.drawText("NEPTUNE",x[7]+10, y[7]-15,paint);

    }
    void nextFrame() {
        moveBalls();
        invalidate();
    }
    class MyTimer extends CountDownTimer {
        MyTimer() {
            super(1000000, 1);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            nextFrame();
        }
        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
        }
    }
}
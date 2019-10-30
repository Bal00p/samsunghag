package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyPaint extends View {

    int N = 50; // количество шариков
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int[] Red = new int[N];
    int[] Green = new int[N];
    int[] Blue = new int[N];
//    public MyPaint(Context context) {
//        super(context);
//        for (int i = 0; i < N; i++) {
//            x[i] = (float) (Math.random() * 500);
//            y[i] = (float) (Math.random() * 500);
//            vx[i] = (float) (Math.random() * 6 - 3);
//            vy[i] = (float) (Math.random() * 6 - 3);
//        }
//    }

    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    void fillArrayRandom(int[] a, int min, int max) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
    }

    void colorRand(){
            fillArrayRandom(Red, 50, 255);
            fillArrayRandom(Green, 50, 255);
            fillArrayRandom(Blue, 50, 255);
    }

    public MyPaint(Context context) {
        super(context);
        fillRandom(x, 100, 500);
        fillRandom(y, 100, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, -3, 3);
    }

    void add(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }

    Paint paint = new Paint();



    void drawBalls(Canvas canvas){
        colorRand();
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
            paint.setColor(Color.argb(255, Red[i],Green[i],Blue[i]));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // отрисовываем все шарики
        drawBalls (canvas);
        // готовим массивы x и у для следущего кадра
        add(x, vx);
        add(y, vy);
        //запрашиваем перерисовку
        invalidate();
    }
}

package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends Activity implements OnClickListener,
        OnLongClickListener {

    private int n = 5;

    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();
        generate();
    }


    void generate() {

        int num=1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                cells[i][j].setText(num + "");
                num++;
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (Math.random() >= 0.5)
                {
                    cells[i][j].setBackgroundColor(Color.GRAY);
                } else cells[i][j].setBackgroundColor(Color.BLACK);

    }


    @Override
    public boolean onLongClick(View v) {


        return false;
    }


    @Override
    public void onClick(View v) {

        Button tappedCell = (Button) v;
        //Получаем координтаты нажатой клетки
        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        //int color = ((ColorDrawable)cells[tappedY][tappedX].getBackground()).getColor();
        for (int x = 0; x < n; x++)
        {
            if(((ColorDrawable)cells[tappedY][x].getBackground()).getColor()==(Color.GRAY))
            cells[tappedY][x].setBackgroundColor(Color.BLACK);
            else cells[tappedY][x].setBackgroundColor(Color.GRAY);
        }
        for (int y = 0; y < n; y++)
        {
            if(((ColorDrawable)cells[y][tappedX].getBackground()).getColor()==(Color.GRAY))
            cells[y][tappedX].setBackgroundColor(Color.BLACK);
            else cells[y][tappedX].setBackgroundColor(Color.GRAY);
        }
        if (((ColorDrawable)cells[tappedY][tappedX].getBackground()).getColor()==(Color.GRAY))
            cells[tappedY][tappedX].setBackgroundColor(Color.BLACK);
        else cells[tappedY][tappedX].setBackgroundColor(Color.GRAY);

    }


    /*
     * NOT FOR THE BEGINNERS
     * ==================================================
     */


    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }


    void makeCells() {
        cells = new Button[n][n];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(n);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}
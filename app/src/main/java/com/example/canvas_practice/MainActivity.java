package com.example.canvas_practice;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.mainlayout);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth = metrics.widthPixels;
        int screenHeigth = metrics.heightPixels;
        String msg = "screenHeight: " + screenHeigth + " screenWidth: " + screenWidth;
        Log.v("Sizes",msg);

        int xValue = metrics.widthPixels/2;
        int yValue = metrics.heightPixels/2;

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

       float scale = (float) 0.5;


        for(int row = 0; row < 5;row++) {
            for(int col = 0; col < 4; col++) {

                ImageView petal_imageview = (ImageView) layoutInflater.inflate(R.layout.petal, null);

                petal_imageview.setScaleX(scale);
                petal_imageview.setScaleY(scale);
                petal_imageview.setRotation(20);

                petal_imageview.setX(col * 200);
                petal_imageview.setY(row * 300);


                myLayout.addView(petal_imageview);

            }
            scale-=(float).1;
        }

    }
}

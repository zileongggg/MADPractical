package com.example.practical_4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class CustomView extends View {

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) { // canvas is like drawing pad.
            /**
             * Question 1: Draw out two different types of fonts under different styles
             * 1. set the background color.
             * 2. set the paint color.
             *    a. ANTI_ALIAS: replace the jagger line with smooth line.
             * 3. set the fonts size, color, type.
             * 4. drawing primitive operations / shape
             */

            canvas.drawColor(Color.DKGRAY);
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

            Typeface typeface;
            typeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);

            paint.setColor(Color.GREEN);
            paint.setTextSize(40);
            paint.setTypeface(typeface);
            canvas.drawText("This is my Low-Level_UI using View.", 10, 50, paint);

            Typeface typeface1;
            typeface1 = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);

            paint.setColor(Color.parseColor("aqua"));
            paint.setTypeface(typeface1);
            canvas.drawText("2ND Low_Level_UI with View", 10, 100, paint);

        }
    }
}
package com.example.practical_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    public static class CustomView extends View {

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);

            // Method 1: Draw shape on CustomView
            int x = 100;
            int y = 100;
            int w = 600;
            int h = 100;

            drawable = new ShapeDrawable(new ArcShape(0, 360));
            drawable.getPaint().setColor(0xff74AC23);
            drawable.setBounds(x, y, x+w, y+h);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            drawable.draw(canvas);

        }
    }
}
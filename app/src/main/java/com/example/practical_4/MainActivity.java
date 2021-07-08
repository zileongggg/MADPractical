package com.example.practical_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Question 5: Draw a simple snake using Path
         */

        Path p = new Path();
        p.moveTo(0, 40); // starting position
        p.lineTo(25, 15); // next position
        p.lineTo(30, 30);
        p.lineTo(32, 45);
        p.lineTo(30, 60);
        p.lineTo(28, 85);
        p.lineTo(40, 90);
        p.lineTo(50, 70);
        p.lineTo(53, 55);
        p.lineTo(56, 55);
        p.lineTo(65, 85);
        p.lineTo(80, 90);
        p.lineTo(85, 87);
        p.lineTo(90, 85);
        p.lineTo(87, 90);
        p.lineTo(80, 100);
        p.lineTo(63, 90);
        p.lineTo(55, 65);
        p.lineTo(50, 85);
        p.lineTo(42, 100);
        p.lineTo(25, 90);
        p.lineTo(27, 50);
        p.lineTo(25, 25);
        p.lineTo(7, 50);
        p.lineTo(20, 25);
        p.lineTo(0, 40);

        ShapeDrawable snake = new ShapeDrawable(new PathShape(p, 100, 100));
        snake.setIntrinsicHeight(1);
        snake.setIntrinsicWidth(1);
        snake.getPaint().setColor(Color.RED);
        snake.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        // set to image View
        ImageView iv = new ImageView(this);
        iv.setImageDrawable(snake);

        setContentView(iv);
//        setContentView(new CustomView(this));
    }

    public static class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            /**
             * Question 5: Draw a simple snake using Path in on Draw
             */

/*          Path p = new Path();
            p.moveTo(0, 40); // starting position
            p.lineTo(25, 15); // next position
            p.lineTo(30, 30);
            p.lineTo(32, 45);
            p.lineTo(30, 60);
            p.lineTo(28, 85);
            p.lineTo(40, 90);
            p.lineTo(50, 70);
            p.lineTo(53, 55);
            p.lineTo(56, 55);
            p.lineTo(65, 85);
            p.lineTo(80, 90);
            p.lineTo(85, 87);
            p.lineTo(90, 85);
            p.lineTo(87, 90);
            p.lineTo(80, 100);
            p.lineTo(63, 90);
            p.lineTo(55, 65);
            p.lineTo(50, 85);
            p.lineTo(42, 100);
            p.lineTo(25, 90);
            p.lineTo(27, 50);
            p.lineTo(25, 25);
            p.lineTo(7, 50);
            p.lineTo(20, 25);
            p.lineTo(0, 40);

            Paint snakePaint = new Paint();
            snakePaint.setColor(Color.CYAN);
            snakePaint.setStyle(Paint.Style.STROKE); // only the boundary
            canvas.drawPath(p, snakePaint);*/
        }
    }
}
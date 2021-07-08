package com.example.practical_4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
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
         * Question 5: Draw a Pac-Man on onCreate
         * cannot overlap, so cannot draw eye
         */

        /*ShapeDrawable pMan = new ShapeDrawable(new ArcShape(40, 290));
        pMan.setIntrinsicHeight(100);
        pMan.setIntrinsicWidth(100);
        pMan.getPaint().setColor(Color.RED);

        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(pMan);
        setContentView(imageView);*/

        setContentView(new CustomView(this));
    }

    public static class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            /**
             * Question 5: Draw a Pac-Man on onCreate
             */

            Paint pManpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            pManpaint.setColor(Color.YELLOW);
            canvas.drawArc(new RectF(getWidth()/2-200, 200, getWidth()/2+200, 600),
                    40, 290, true, pManpaint);

            // small pac man
            // canvas.drawArc(new RectF(100, 450, 200, 550), 40, 290, true, pManpaint);

            // eye of the pacman
            pManpaint.setColor(Color.BLACK);
            canvas.drawCircle(getWidth()/2+20, getWidth()/2-90, 20, pManpaint);
        }
    }
}
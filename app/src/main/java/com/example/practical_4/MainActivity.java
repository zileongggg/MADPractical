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
         * Question 3: Draw an Inner Rounded Rectangle and a normal Rectangle
         * Comment out to see 2 difference code
         */
        ShapeDrawable rect = new ShapeDrawable(new RectShape());
        rect.getPaint().setColor(Color.YELLOW);
        rect.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        // rounded rectangle
        float [] outerRadii = new float[]{5, 5, 5, 5, 5, 5, 5, 5}; // outer radius value
        float [] innerRadii = new float[]{5, 5, 5, 5, 5, 5, 5, 5}; // inner radius value
        RectF insetRectangle = new RectF(10, 10, 10, 10);

        ShapeDrawable roundedRect = new ShapeDrawable(new RoundRectShape(outerRadii, insetRectangle, innerRadii));
        roundedRect.getPaint().setColor(Color.RED);

        // aspect ratio for width and height
        rect.setIntrinsicHeight(1);
        rect.setIntrinsicWidth(2);
        roundedRect.setIntrinsicHeight(50);
        roundedRect.setIntrinsicWidth(100);

        // Create ImageView to show Rectangle
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(rect);
        imageView.setImageDrawable(roundedRect);

        // Set content View to ImageView
        setContentView(imageView);
    }

    public static class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
        }
    }
}
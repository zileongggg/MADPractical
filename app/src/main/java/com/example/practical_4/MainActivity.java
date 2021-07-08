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
        public CustomView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            /**
             *  Question 2: Draw an image to be slanted and flipped
             */
            Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.mario);

            // Transformation: Scaling, TRanslation, Rotation, Reflection
            Matrix matrix = new Matrix();
            matrix.preScale(0.3f, 0.3f);
            matrix.preRotate(20);

            Bitmap transformedPic = Bitmap.createBitmap(picture, 0,0, picture.getWidth(), picture.getHeight(), matrix,false);
            canvas.drawBitmap(transformedPic, 10, 150, null);

        }
    }
}
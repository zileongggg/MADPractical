package com.example.practical_4;

import androidx.appcompat.app.AppCompatActivity;

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
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Exercise 4: draw rectangle on onCreate
        ShapeDrawable rect = new ShapeDrawable(new RectShape());
        rect.getPaint().setColor(Color.YELLOW);
        rect.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);

        // aspect ratio
        rect.setIntrinsicHeight(1);
        rect.setIntrinsicWidth(1);

        // rounded rectangle
        float [] outerRadii = new float[]{5, 5, 5, 5, 5, 5, 5, 5}; // outer radius value
        float [] innerRadii = new float[]{5, 5, 5, 5, 5, 5, 5, 5}; // inner radius value
        RectF insetRectangle = new RectF(10, 10, 10, 10);
        ShapeDrawable roundedRect = new ShapeDrawable(new RoundRectShape(outerRadii, insetRectangle, innerRadii));

        roundedRect.setIntrinsicHeight(50);
        roundedRect.setIntrinsicWidth(100);
        roundedRect.getPaint().setColor(Color.YELLOW);

        // Exercise 5: Draw a Pacman
        ShapeDrawable pMan = new ShapeDrawable(new ArcShape(40, 290));
        pMan.setIntrinsicHeight(100);
        pMan.setIntrinsicWidth(100);
        pMan.getPaint().setColor(Color.YELLOW);

        // Exercise 6 : Draw a snake
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

        // it will occupy the full screen
        ImageView iv = new ImageView(this);
        iv.setImageDrawable(snake);

        setContentView(iv);
//        setContentView(new CustomView(this));
    }

    public static class CustomView extends View {

        private ShapeDrawable drawable;

        public CustomView(Context context) {
            super(context);

            // Exercise 3: draw rectangle
            int x = 100;
            int y = 100;
            int w = 600;
            int h = 100;

            drawable = new ShapeDrawable(new ArcShape(0, 360));
            drawable.getPaint().setColor(0xff74AC23);
            drawable.setBounds(x, y, x+w, y+h);
        }
        @Override
        protected void onDraw(Canvas canvas) {      // Canvas == drawing pad
            // set bg color
            canvas.drawColor(Color.DKGRAY);

            // set paint color
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);     // Anti alias: replace the jagger line with smooth line

            // 2nd Component: Fonts
            Typeface typeface;
            typeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);

            paint.setColor(Color.GREEN);
            paint.setTextSize(40);
            paint.setTypeface(typeface);

            // 3rd component: drawing primitive operations / shape
//            canvas.drawText("This is my Low-Level_UI using View.", 10, 50, paint);

            // Second format
            paint.setColor(Color.parseColor("aqua"));

            Typeface typeface1;
            typeface1 = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);
            paint.setTypeface(typeface1);
//            canvas.drawText("2ND Low_Level_UI with View", 10, 100, paint);


            // Exercise 2
            // Fourth component
            Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.mario);

            // Transformation: Scaling, TRanslation, Rotation, Reflection
            Matrix matrix = new Matrix();
            matrix.preScale(0.3f, 0.3f);
            matrix.preScale(-1.0f, 1.0f);
            matrix.preRotate(20);

            Bitmap transformedPic = Bitmap.createBitmap(picture, 0,0,
                    picture.getWidth(), picture.getHeight(), matrix,false);
//            canvas.drawBitmap(transformedPic, 10, 150, null);

            // call draw method for exercise 4
//            drawable.draw(canvas);

            // Exercise 5: pacman
            Paint pManpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            pManpaint.setColor(Color.YELLOW);

//            canvas.drawArc(new RectF(100, 450, 200, 550),
//                    40, 290, true, pManpaint);

            canvas.drawArc(new RectF(getWidth()/2-200, 200, getWidth()/2+200, 600),
                    40, 290, true, pManpaint);

            // eye of the pacman
            pManpaint.setColor(Color.BLACK);
            canvas.drawCircle(getWidth()/2+20, getWidth()/2-250, 20, pManpaint);

            // Exercise 6: Draw a snake
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

            Paint snakePaint = new Paint();
            snakePaint.setColor(Color.CYAN);
            snakePaint.setStyle(Paint.Style.STROKE); // only the boundary
            canvas.drawPath(p, snakePaint);
        }
    }
}
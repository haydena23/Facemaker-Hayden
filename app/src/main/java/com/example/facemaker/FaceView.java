package com.example.facemaker;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView {

    Paint eyePaint = new Paint();
    Paint skinPaint = new Paint();
    Paint hairPaint = new Paint();

    private Face faceMod = new Face();

    public Face getFaceMod() {
        return faceMod;
    }

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
    }

    public void onDraw(Canvas canvas) {
        eyePaint.setColor(convertColors(faceMod.eyeColorR,faceMod.eyeColorG,faceMod.eyeColorB));
        skinPaint.setColor(convertColors(faceMod.skinColorR,faceMod.skinColorG,faceMod.skinColorB));
        hairPaint.setColor(convertColors(faceMod.hairColorR,faceMod.hairColorG,faceMod.hairColorB));

        drawFace(canvas,eyePaint,skinPaint,hairPaint);
    }

    public int convertColors(int r, int g, int b) {
        int RGB = android.graphics.Color.rgb(r,g,b);
        return RGB;
    }

    public void drawFace(Canvas canvas, Paint eyeP, Paint skinP, Paint hairP) {
        //Face
        canvas.drawCircle((float)canvas.getWidth()/2, (float)canvas.getHeight()/2, 200,skinPaint);

        //Eyes

    }

}

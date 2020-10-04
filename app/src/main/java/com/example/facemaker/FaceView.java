/*
@author Tony Hayden
 */

package com.example.facemaker;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView {

    Paint eyePaint = new Paint();
    Paint skinPaint = new Paint();
    Paint hairPaint = new Paint();
    Paint mouthPaint = new Paint();
    Paint eyeWhite = new Paint();
    Paint eyeBlack = new Paint();
    Paint textColorRed = new Paint();
    Paint textColorGreen = new Paint();
    Paint textColorBlue = new Paint();

    private Face faceMod = new Face();

    public Face getFaceMod() {
        return faceMod;
    }

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        mouthPaint.setColor(Color.BLACK);
        eyeWhite.setColor(Color.WHITE);
        eyeBlack.setColor(Color.BLACK);
        textColorRed.setColor(Color.RED);
        textColorRed.setTextSize(30f);
        textColorGreen.setColor(Color.GREEN);
        textColorGreen.setTextSize(30f);
        textColorBlue.setColor(Color.BLUE);
        textColorBlue.setTextSize(30f);
    }

    public void onDraw(Canvas canvas) {
        eyePaint.setColor(convertColors(faceMod.eyeColorR,faceMod.eyeColorG,faceMod.eyeColorB));
        skinPaint.setColor(convertColors(faceMod.skinColorR,faceMod.skinColorG,faceMod.skinColorB));
        hairPaint.setColor(convertColors(faceMod.hairColorR,faceMod.hairColorG,faceMod.hairColorB));

        drawFace(canvas);
        drawHair(canvas, faceMod.hairStyle);
        drawEyes(canvas);
    }

    public int convertColors(int r, int g, int b) {
        return Color.rgb(r,g,b);
    }

    public void drawFace(Canvas canvas) {
        //Face
        canvas.drawCircle((float)canvas.getWidth()/2, (float)canvas.getHeight()/2, 200, skinPaint);
        canvas.drawArc(850f,400,1070,525,0,180,true, mouthPaint);
    }

    public void drawHair(Canvas canvas, int hairStyle) {
        if(hairStyle == 1) {
            drawTriangle(canvas,hairPaint,960,150,100);
        }
        if(hairStyle == 2) {
            canvas.drawArc(((float)canvas.getWidth()/2)-162,((float)canvas.getHeight()/2)-200,((float)canvas.getWidth()/2)+162,350,180,180,false, hairPaint);
        }
    }

    public void drawEyes(Canvas canvas) {
        canvas.drawCircle(900f,325f,50f,eyeWhite);
        canvas.drawCircle(1020f,325f,50f,eyeWhite);
        canvas.drawCircle(1020f,325f,20f,eyePaint);
        canvas.drawCircle(900,325f,20f,eyePaint);
        canvas.drawCircle(1020f,325f,5f,eyeBlack);
        canvas.drawCircle(900,325f,5f,eyeBlack);
    }

    /**
     * External Citation
     *  Date: 4 October 2020
     *  Problem : Couldn't get a nice looking triangle
     *  Resource:
     *      https://kylewbanks.com/blog/drawing-triangles-rhombuses-and-other-shapes-on-android-canvas
     *  Solution: Used code, looks much better
     */
    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - (2*halfWidth)); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - (2*halfWidth)); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

}

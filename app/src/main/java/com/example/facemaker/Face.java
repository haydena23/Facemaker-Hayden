package com.example.facemaker;

import java.util.*;

public class Face{

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    /**
     * External Citation
     *  Date: 9 September 2020
     *  Problem : Random() not working, wrong method as well
     *  Resource:
     *      https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
     *  Solution: Looked at Java documentation, found correct method
     *            of nextInt(), and import java.util.*
     */
    Random rand = new Random();

    public static void main(String[] args) {
        Face face1 = new Face();
    }

    public Face() {
        randomize();
    }

    private void randomize() {
        this.skinColor = rand.nextInt(256);
        this.eyeColor = rand.nextInt(256);
        this.hairColor = rand.nextInt(256);
        this.hairStyle = rand.nextInt(3);
    }
}

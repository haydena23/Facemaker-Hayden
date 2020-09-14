/*
@author Tony Hayden
 */

package com.example.facemaker;

import java.util.*;

public class Face{

    public int skinColorR = 0;
    public int skinColorG = 0;
    public int skinColorB = 0;
    public int eyeColorR = 0;
    public int eyeColorG = 0;
    public int eyeColorB = 0;
    public int hairColorR = 0;
    public int hairColorG = 0;
    public int hairColorB = 0;
    public int hairStyle = 0;

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

    public void randomize() {
        this.skinColorR = rand.nextInt(256);
        this.skinColorG = rand.nextInt(256);
        this.skinColorB = rand.nextInt(256);
        this.eyeColorR = rand.nextInt(256);
        this.eyeColorG = rand.nextInt(256);
        this.eyeColorB = rand.nextInt(256);
        this.hairColorR = rand.nextInt(256);
        this.hairColorG = rand.nextInt(256);
        this.hairColorB = rand.nextInt(256);
        this.hairStyle = rand.nextInt(3);
    }
}

package com.example.facemaker;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener{

    private FaceView faceView1;
    private Face face1;

    public String text = "Skin";

    public FaceController(FaceView faceViewRef) {
        faceView1 = faceViewRef;
        face1 = faceView1.getFaceMod();
    }

    @Override
    public void onClick(View view) {
        face1.randomize();
        faceView1.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        String name = seekBar.getTag().toString();
        if(name.equals("seekBarRed")) {
            switch(text) {
                case "Skin":
                    face1.skinColorR = progress;
                    break;
                case "Eyes":
                    face1.eyeColorR = progress;
                    break;
                case "Hair":
                    face1.hairColorR = progress;
                    break;
            }
        }
        if(name.equals("seekBarGreen")) {
            switch(text) {
                case "Skin":
                    face1.skinColorG = progress;
                    break;
                case "Eyes":
                    face1.eyeColorG = progress;
                    break;
                case "Hair":
                    face1.hairColorG = progress;
                    break;
            }
        }
        if(name.equals("seekBarBlue")) {
            switch(text) {
                case "Skin":
                    face1.skinColorB = progress;
                    break;
                case "Eyes":
                    face1.eyeColorB = progress;
                    break;
                case "Hair":
                    face1.hairColorB = progress;
                    break;
            }
        }
        System.out.println(face1.skinColorR);
        System.out.println(face1.skinColorG);
        System.out.println(face1.skinColorB);
        System.out.println(face1.eyeColorR);
        System.out.println(face1.eyeColorG);
        System.out.println(face1.eyeColorB);
        System.out.println(face1.hairColorR);
        System.out.println(face1.hairColorG);
        System.out.println(face1.hairColorB);
        faceView1.invalidate();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        /**
         * External Citation
         *  Date: 13 September 2020
         *  Problem : Get the text of RadioButton to know which one is clicked
         *  Resource:
         *      https://stackoverflow.com/questions/6440259/how-to-get-the-selected-index-of-a-radiogroup-in-android
         *  Solution: Copied code
         */
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);
        text = r.getText().toString();
        faceView1.invalidate();


        /*SeekBar sbr = faceView1.findViewById((R.id.seekBarRed));
        SeekBar sbg = faceView1.findViewById((R.id.seekBarGreen));
        SeekBar sbb = faceView1.findViewById((R.id.seekBarBlue));

        switch(text) {
            case "Skin":
                sbr.setProgress(face1.skinColorR);
                sbg.setProgress(face1.skinColorG);
                sbb.setProgress(face1.skinColorB);
                break;
            case "Eyes":
                sbr.setProgress(face1.eyeColorR);
                sbg.setProgress(face1.eyeColorG);
                sbb.setProgress(face1.eyeColorB);
                break;
            case "Hair":
                sbr.setProgress(face1.hairColorR);
                sbg.setProgress(face1.hairColorG);
                sbb.setProgress(face1.hairColorB);
                break;
        }*/
    }
}

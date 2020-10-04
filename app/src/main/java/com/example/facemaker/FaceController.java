/*
@author Tony Hayden
 */

package com.example.facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{

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
            switch (text) {
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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        face1.hairStyle = parent.getSelectedItemPosition();
        faceView1.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

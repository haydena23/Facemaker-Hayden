/*
@author Tony Hayden
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceView fv1 = findViewById(R.id.FaceView);
        FaceController fc1 = new FaceController(fv1);
        Face fa1 = new Face();

        /**
         * External Citation
         *  Date: 9 September 2020
         *  Problem : Not sure how to get Spinner working
         *  Resource:
         *      https://www.youtube.com/watch?v=on_OrrX7Nw4
         *  Solution: Followed tutorial and applied to my needs
         */
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hairStyle, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(fc1);
        spinner.setSelection(fa1.hairStyle);

        Button randButton = findViewById(R.id.button);
        randButton.setOnClickListener(fc1);

        RadioGroup group1 = findViewById(R.id.radioGroup1);
        group1.setOnCheckedChangeListener(fc1);

        SeekBar redBar = findViewById(R.id.seekBarRed);
        redBar.setOnSeekBarChangeListener(fc1);
        SeekBar greenBar = findViewById(R.id.seekBarGreen);
        greenBar.setOnSeekBarChangeListener(fc1);
        SeekBar blueBar = findViewById(R.id.seekBarBlue);
        blueBar.setOnSeekBarChangeListener(fc1);

        redBar.setProgress(fa1.skinColorR);
        greenBar.setProgress(fa1.skinColorG);
        blueBar.setProgress((fa1.skinColorB));
    }
}
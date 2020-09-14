/*
@author Tony Hayden
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceView fv1 = findViewById(R.id.FaceView);
        FaceController fc1 = new FaceController(fv1);

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
        spinner.setOnItemSelectedListener(this);

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

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
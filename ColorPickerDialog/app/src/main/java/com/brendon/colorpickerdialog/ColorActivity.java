package com.brendon.colorpickerdialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class ColorActivity extends AppCompatActivity implements
ColorPickerDialogFragment.ColorDialogSelectionListener{

    int mBackgroundColor;
    Button mChooseBackgroundColor;
    RelativeLayout mBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mBackground = (RelativeLayout) findViewById(R.id.background);
        mChooseBackgroundColor = (Button) findViewById(R.id.show_color_dialog_button);



        mChooseBackgroundColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ColorPickerDialogFragment dialog = ColorPickerDialogFragment.newInstance();
                dialog.show(getFragmentManager(), "Show dialog");

            }
        });

    }

    @Override
    public void colorSelected(int colorRed, int colorGreen, int colorBlue) {

        mBackground.setBackgroundColor(Color.rgb(colorRed,colorGreen,colorBlue));

    }
}

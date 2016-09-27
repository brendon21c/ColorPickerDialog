package com.brendon.colorpickerdialog;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ColorPickerDialogFragment extends DialogFragment{

    /*
    // The data is the text to be displayed in the dialog's list
    final CharSequence[] COLOR_CHOICES = {"Red", "Blue", "Green"};

    // Color Values
    final int[] COLOR_VALUES = {Color.RED,Color.BLUE, Color.GREEN};
    */

    // New section for Scrollbars
    SeekBar mScrollBarRed;
    SeekBar mScrollBarBlue;
    SeekBar mScrollBarGreen;

    TextView mScrollValueRed;
    TextView mScrollValueGreen;
    TextView mScrollValueBlue;


    //User selected colors for custom color.
    int mColorValueRed;
    int mColorValueGreen;
    int mColorValueBlue;

    Button mUpdateButton;





    // Interface for the listener
    interface ColorDialogSelectionListener {

        void colorSelected(int colorRed, int colorGreen, int colorBlue);

    }

    private ColorDialogSelectionListener mListener;


    public static ColorPickerDialogFragment newInstance() {

        ColorPickerDialogFragment fragment = new ColorPickerDialogFragment();
        return fragment;

    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);

        if (activity instanceof ColorDialogSelectionListener) {

            mListener = (ColorDialogSelectionListener) activity;

        } else {

            throw new RuntimeException(activity.toString() + " must implement ColorDialogSelectionListener");

        }

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a background color.");

        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View v = inflater.inflate(R.layout.color_picker_rgb_scale, null);
        builder.setView(v);

        mUpdateButton = (Button) v.findViewById(R.id.update_button);

        mScrollBarRed = (SeekBar) v.findViewById(R.id.scrollbar_red);
        mScrollBarBlue = (SeekBar)  v.findViewById(R.id.scrollbar_blue);
        mScrollBarGreen = (SeekBar)  v.findViewById(R.id.scrollbar_green);

        mScrollValueRed = (TextView) v.findViewById(R.id.scroll_bar_value_red);
        mScrollValueGreen = (TextView) v.findViewById(R.id.scrollbar_value_green);
        mScrollValueBlue = (TextView) v.findViewById(R.id.scrollbar_value_blue);

        // displays the total for Red scrollbar and sets color value.
        mScrollBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {

                mScrollValueRed.setText("Red value: " + value);
                mColorValueRed = value;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // displays the total for the Green scrollbar and sets color value.

        mScrollBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {

                mScrollValueGreen.setText("Green value: " + value);
                mColorValueGreen = value;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // displays the total for the Blue scrollbar and sets color value.

        mScrollBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {

                mScrollValueBlue.setText("Blue value: " + value);
                mColorValueBlue = value;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Will Change the screen to the RGB color code.
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.colorSelected(mColorValueRed, mColorValueGreen, mColorValueBlue);


            }
        });



        return builder.create();
    }




}

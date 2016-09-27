package com.brendon.colorpickerdialog;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

public class ColorPickerDialogFragment extends DialogFragment{

    // The data is the text to be displayed in the dialog's list
    final CharSequence[] COLOR_CHOICES = {"Red", "Blue", "Green"};

    // Color Values
    final int[] COLOR_VALUES = {Color.RED,Color.BLUE, Color.GREEN};

    // Interface for the listener
    interface ColorDialogSelectionListener {

        void colorSelected(int color);

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

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose a background color.")
                .setItems(COLOR_CHOICES, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {


                        mListener.colorSelected(COLOR_VALUES[which]);
                    }
                });

        return builder.create();
    }


}

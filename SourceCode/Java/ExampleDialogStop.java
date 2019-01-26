package com.example.a2019nanyanewyear;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;

public class ExampleDialogStop extends AppCompatDialogFragment {
    //private EditText editTextUsername;
    public String i;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialogstop, null);

        builder.setView(view)
                .setTitle("Confirm")
                .setMessage("The game is finish: ")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
        //editTextUsername = view.findViewById(R.id.edit_username);
        return builder.create();
    }


}

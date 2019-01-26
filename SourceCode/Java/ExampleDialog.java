package com.example.a2019nanyanewyear;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextUsername;
    public String i;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());



        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Confirm")
                .setMessage("Do you want to upload score: " + String.valueOf(i))
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = editTextUsername.getText().toString().trim();
                        if(TextUtils.isEmpty(username)){
                            username = "Oops ! I forgot to enter the name";
                        }
                        Score score = new Score(username, i);
                        //score.setUsername(username);
                        //score.setPlayscore(i);
                        new FirebaseDatabaseHelper().addScores(score);

                    }
                });
        editTextUsername = view.findViewById(R.id.edit_username);
        return builder.create();
    }


}

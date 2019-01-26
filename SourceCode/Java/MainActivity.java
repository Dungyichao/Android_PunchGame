package com.example.a2019nanyanewyear;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.ConnectivityManager;
import android.content.Context;
import android.widget.Button;
import android.view.View;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity{

    int score;
    public int counter;
    EditText displayfield;
    Boolean cancount = false;
    Boolean uploadscore = false;
    Button start_time_button;
    TextView textView;
    CountDownTimer yourCountDownTimer;
    AlertDialog.Builder builder;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        displayfield = (EditText) findViewById(R.id.display);
        textView= (TextView) findViewById(R.id.textView);
        displayfield.setText(String.valueOf(score));
        counter = 0;
        FirebaseApp.initializeApp(this);




    }

    public void Cancel_click(View v){

        cancount = false;
        score = 0;
        counter = 0;
        displayfield.setText(String.valueOf(score));
        textView.setText(String.valueOf(30));
        yourCountDownTimer.cancel();
    }

    public void love_click(View v){
        if(score == 0){
            // start timer
            cancount = true;
            yourCountDownTimer =  new CountDownTimer(30000, 1000){
                public void onTick(long millisUntilFinished){
                    textView.setText(String.valueOf(29 - counter));
                    counter++;
                }
                public  void onFinish(){
                    cancount = false;
                    textView.setText("FINISH!!");

                    //mDatabase = FirebaseDatabase.getInstance();
                    //mReferenceScores = mDatabase.getReference("Score");
                    //Score scores = new Score("Tony", String.valueOf(score));
                    //String key = mReferenceScores.push().getKey();
                    //mReferenceScores.child(key).setValue(scores);
                    openDialog();
                    openDialog2();
                    //Toast.makeText(getApplicationContext()," Score Uploaded! ",Toast.LENGTH_LONG).show();
                    textView.setText("30");
                    displayfield.setText("0");
                    //Toast.makeText(getApplicationContext()," Score Uploaded! ",Toast.LENGTH_LONG).show();
                    //cancount = true;


                }
            }.start();

        }
        if(cancount == true || score == 0){
            score = score + 1;
            displayfield.setText(String.valueOf(score));
        }
    }

    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.i = String.valueOf(score);
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
        score = 0;
        counter = 0;

    }

    public void openDialog2(){
        ExampleDialogStop exampleDialogStop = new ExampleDialogStop();
        exampleDialogStop.show(getSupportFragmentManager(), "example dialog");

    }






}

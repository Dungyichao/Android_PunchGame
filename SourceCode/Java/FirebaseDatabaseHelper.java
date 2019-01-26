package com.example.a2019nanyanewyear;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceScores;
    //private List<Score> scores = new ArrayList<>();

    public interface DataStatus{
        //void DataIsLoaded(List<Score> scores, List<String> keys);
        void DataIsInserted();
    }

    public FirebaseDatabaseHelper() {
        //FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance();
        mReferenceScores = mDatabase.getReference().child("Score");
    }

    public void addScores(Score score){
        Log.i("non", "in database");
        //mDatabase = FirebaseDatabase.getInstance();
        //mReferenceScores = mDatabase.getReference("Score");
        String key = mReferenceScores.push().getKey();
        mReferenceScores.child(key).setValue(score);

    }
}

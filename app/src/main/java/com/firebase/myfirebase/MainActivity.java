package com.firebase.myfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    Button mButtonSunny;
    Button mButtonFoggy;
    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mTextView = (TextView)findViewById(R.id.textViewWeather);
        mButtonSunny = (Button)findViewById(R.id.buttonSunny);
        mButtonFoggy = (Button)findViewById(R.id.button2Foggy);
        mRef = new Firebase("https://myfirebaseandroidapp.firebaseio.com/Weather");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                mTextView.setText(data);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mButtonFoggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Foggy");
            }
        });
        mButtonSunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("Sunny");
            }
        });
    }
}

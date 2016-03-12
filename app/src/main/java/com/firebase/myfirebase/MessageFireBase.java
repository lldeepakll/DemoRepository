package com.firebase.myfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import javax.crypto.Mac;

/**
 * Created by HP LAPTOP on 11-03-2016.
 */
public class MessageFireBase extends AppCompatActivity {

    TextView message;
    Button send;
    Firebase mRef2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        message = (TextView)findViewById(R.id.msgText);
        send = (Button)findViewById(R.id.buttonSend);

        mRef2 = new Firebase("https://myfirebaseandroidapp.firebaseio.com/message");

        mRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();
                mRef2.setValue(msg);
            }
        });

    }
}

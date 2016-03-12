package com.firebase.myfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by HP LAPTOP on 11-03-2016.
 */
public class UserFireBase extends AppCompatActivity {

    TextView myTextView;
    Firebase mRef3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_get_msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myTextView = (TextView)findViewById(R.id.broadcastMessage);

        mRef3 = new Firebase("https://myfirebaseandroidapp.firebaseio.com/message");

        mRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                myTextView.setText(message);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}

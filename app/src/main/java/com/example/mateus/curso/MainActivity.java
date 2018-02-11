package com.example.mateus.curso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private EditText name;

    private DatabaseReference mDatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);
        name = (EditText) findViewById(R.id.name);
        mDatabse = FirebaseDatabase.getInstance().getReference();

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mDatabse.push().setValue(name.getText().toString());
            }
        });
    }
}

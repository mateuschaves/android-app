package com.example.mateus.curso;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mFirebaseBtn;
    private EditText mName;
    private EditText mEmail;
    private DatabaseReference mDatabse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseBtn    =   (Button) findViewById(R.id.firebase_btn);
        mName           =   (EditText) findViewById(R.id.name);
        mEmail          =   (EditText) findViewById(R.id.email);
        mDatabse        =    FirebaseDatabase.getInstance().getReference();
        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString().trim();
                String email = mEmail.getText().toString().trim();
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Name", name);
                dataMap.put("Email", email);
                mDatabse.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Stored", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Error... ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}

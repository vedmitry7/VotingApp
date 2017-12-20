package com.vedmitryapps.votingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText roomIdEditText;

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();

    }


    public void onClick245(View v){
        switch(v.getId()) {
            case R.id.create_finish_button:
                Log.i("TAG21", "Create finish button click.");

                Room room = new Room();
                myRef.child(roomIdEditText.getText().toString()).setValue(room).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful()){
                           Log.i("TAG21", "Room added.");
                           Intent intent = new Intent(SettingActivity.this, ServerResultActivity.class);
                           startActivity(intent);
                       }
                    }
                });

                break;
        }
    }
}

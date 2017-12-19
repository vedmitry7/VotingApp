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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegAuthActivity extends AppCompatActivity {


    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_auth);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.auth_button:
                auth(email.getText().toString(), password.getText().toString());
                break;
            case R.id.reg_button:
                Log.d("TAG21", "Registration button click");
                registration(email.getText().toString(), password.getText().toString());
                break;
        }
    }

    private void auth(final String login, String password){
        mAuth.signInWithEmailAndPassword(login,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("TAG21", "Auth Complete - " + login);
                    Intent intent = new Intent(RegAuthActivity.this, SettingActivity.class);
                    startActivity(intent);
                } else {
                    Log.d("TAG21", "Auth failed - " + login);
                }
            }
        });
    }

    public void registration(final String login, String password){
        mAuth.createUserWithEmailAndPassword(login, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("TAG21", "Registration Complete - " + login);
                    Intent intent = new Intent(RegAuthActivity.this, SettingActivity.class);
                    startActivity(intent);
                } else {
                    Log.d("TAG21", "Registration failed - " + login);
                }
            }
        });
    }
}

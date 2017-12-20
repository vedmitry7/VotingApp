package com.vedmitryapps.votingapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.vedmitryapps.votingapp.fragments.FragmentRegAuth;
import com.vedmitryapps.votingapp.fragments.FragmentSettings;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_log_out, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout){
            Toast.makeText(this,"Logout success", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
        }
        return true;
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.create_button:
                if(mAuth.getCurrentUser()==null){
                    Log.i("TAG21", "user == null");
                    Intent intent = new Intent(this, RegAuthActivity.class);
                    startActivity(intent);
                } else {
                    Log.i("TAG21", "user != null");
                    Intent intent = new Intent(this, SettingActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.connect_button:
                Intent intent = new Intent(this, ClientResultActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void startCreation() {
        Log.d("TAG21", "start Creation Fragment");
        FragmentSettings fragment = new FragmentSettings();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void startRegAuth() {
        Log.d("TAG21", "start RegAuth Fragment");
        Fragment fragment = new FragmentRegAuth();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

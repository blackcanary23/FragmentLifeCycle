package com.example.fragmentlifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MyLogs";
    private Button button1, button2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected  void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected  void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    public void onClick(View view) {
        FragmentManager fMan = getSupportFragmentManager();
        FragmentTransaction fTrans;

        if (view == button1) {
            Fragment1 frag1 = new Fragment1();
            fTrans = fMan.beginTransaction();
            fTrans.replace(R.id.container, frag1, "Frag1");
            fTrans.addToBackStack("Frag1");
            fTrans.commitAllowingStateLoss();
        }
        else if (view == button2) {
            Fragment2 frag2 = new Fragment2();
            fTrans = fMan.beginTransaction();
            fTrans.replace(R.id.container, frag2, "Frag2");
            fTrans.addToBackStack("Frag2");
            fTrans.commitAllowingStateLoss();
        }
    }
}
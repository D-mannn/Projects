package com.example.beatbox;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ДиМкА on 30.08.2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity{
    public abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();

        Fragment f = fm.findFragmentById(R.id.frag_container);

        if (f == null){
            f = createFragment();
            fm.beginTransaction().add(R.id.frag_container, f).commit();
        }
    }
}

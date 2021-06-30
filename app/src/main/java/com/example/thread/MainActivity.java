package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Bundle conf = new Bundle();
        conf.putString("clockPattern","h:m:s");
        mBinding.addButton.setOnClickListener(v -> {
            getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.clockContainer,ClockFragment.class, null, "clock")
        .commit();
        }
        );

        mBinding.removeButton.setOnClickListener(v -> {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("clock");
            getSupportFragmentManager()
            .beginTransaction()
            .remove(fragment)
            .commit();}
            );
    }
}

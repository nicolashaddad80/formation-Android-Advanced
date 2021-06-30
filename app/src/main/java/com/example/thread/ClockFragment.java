package com.example.thread;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.thread.databinding.ActivityMainBinding;
import com.example.thread.databinding.FragmentClockBinding;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClockFragment extends Fragment {

    private FragmentClockBinding b;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);

    private DateTimeFormatter dtf;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null)
            dtf = DateTimeFormatter.ofPattern(args.getString("clockPattern","m:s"));
        else
            dtf = DateTimeFormatter.ofPattern("m:s");
    }
    @Override
    public void onStart() {
        super.onStart();
        timer.scheduleAtFixedRate(()->{
                String time = LocalDateTime.now().format(dtf).toString();
                mainHandler.post(() -> b.textClock.setText(time));
        },
            0,1, TimeUnit.SECONDS
        );
    }

    @Override
    public void onStop() {
        super.onStop();
        timer.shutdown();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        b = FragmentClockBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return b.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}

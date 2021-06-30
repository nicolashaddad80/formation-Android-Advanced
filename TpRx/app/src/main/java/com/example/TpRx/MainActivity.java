package com.example.TpRx;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {
    private TextView mTemperatureText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTemperatureText = findViewById(R.id.temperature);
        TemperatureWebSocket temperatureSocket = new TemperatureWebSocket();
        temperatureSocket.connect();

        Observable<Float> temp = temperatureSocket.getTemperatureStream();


        temp.observeOn(AndroidSchedulers.mainThread()).subscribe(value ->{mTemperatureText.setText(value.toString());},
            ex -> {},
            () -> {}
            );
     /*   WebSocket ws = new WebSocketFactory().createSocket("ws://localhost/endpoint");

        Observable<String> dataFlow = getSourceData();

        Disposable mDisposable = dataFlow.subscribe(
            value ->{},
            ex -> {},
            () -> {}
            );
            */
    }
    /*
    private Observable<String> getSourceData() {
        //Observable.range(1,560000);
        return Observable.just("printemps", "été", "hivers", "automne");
    }

      */
}

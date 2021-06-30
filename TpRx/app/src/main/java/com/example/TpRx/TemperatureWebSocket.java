/*
 * 2021 Developed by Renault SW Labs,
 * an affiliate of RENAULT s.a.s. which holds all intellectual property rights.
 * Use of this software is subject to a specific license granted by Renault s.a.s.
 */
package com.example.TpRx;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

public class TemperatureWebSocket extends WebSocketClient {

    private final static URI WEBSOCKET_URL = java.net.URI.create("ws://test.docdoku.net:3000/temperature");

    public ObservableEmitter<Float> emitter;
    public TemperatureWebSocket() {
        super(WEBSOCKET_URL);
    }

    public TemperatureWebSocket(String webSocketURL){
        super(java.net.URI.create(webSocketURL));
    }

    public Observable<Float> getTemperatureStream() {
        return Observable.create(_emitter ->
        {
            this.emitter = _emitter;
            /*this.emitter.onNext(32F);
            this.emitter.onNext(34F);
            this.emitter.onNext(36F);
            this.emitter.onComplete();
            */

        }
        );
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.d("Web socket", "handshake");
    }

    @Override
    public void onMessage(String message) {
        Log.d("Web socket", message);
        //this.emitter.onNext(666F);


        this.emitter.onNext(Float.parseFloat(message));
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        this.emitter.onComplete();
    }

    @Override
    public void onError(Exception ex) {
        this.emitter.onError(ex);
    }
}

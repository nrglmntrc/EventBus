package com.nurgulmantarci.eventbusstickykullanimi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nurgulmantarci.eventbusstickykullanimi.EventModels.PositionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DigerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diger);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)  //fragmentKOnu direkt olarak yayını fragmentAçıklamaya yollayacak..Frag Açıklamamnın Daha oluşturulmamış olma ihtimaline karşı sticky yapyoruz!!!
    public void onPositionEvent(PositionEvent event){
        FragmentDescription fragmentDescription= (FragmentDescription) getSupportFragmentManager().findFragmentById(R.id.fragmentDescription);
        fragmentDescription.konuyuYukle(event.getPosition());
    }
}

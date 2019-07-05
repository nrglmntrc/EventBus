package com.nurgulmantarci.eventbusstickykullanimi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nurgulmantarci.eventbusstickykullanimi.EventModels.PositionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    //EventBus ile Aktivity ve Fragmentler arasında veri alışverişleri Modellerle sağlanır.
    //Abone olma ve Yayın yapma mantığında çalışır
    //Böylelikle Activtyler ve Fragmentler arasındaki bağımlılık ortadan kalkar..(implemente etme zorunluluğu yoktur)

   String ornek_metin="örnek metin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //Yayına yukarda kayıt olundu ve dinlenilmeye başlandı..position yollandığı zaman burası çalışacak.
    @Subscribe
    public void onPositionEvent(PositionEvent event){
        //positionı all
        int position=event.getPosition();
        FragmentDescription fragmentDescription= (FragmentDescription) getSupportFragmentManager().findFragmentById(R.id.fragmentDescription);

        //landscape modda burası çalışır
        if(fragmentDescription!=null && fragmentDescription.isVisible()){
            fragmentDescription.konuyuYukle(position);
        }

        //portrait modda burası çalışır
        else{
            Intent intent=new Intent(this,DigerActivity.class);
            startActivity(intent);  //Hangi açıklamamnın açılacağı bilgisini EventBus ile Diğer Akt. yollayacağız..
        }

    }
}

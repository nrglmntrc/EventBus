package com.nurgulmantarci.eventbusstickykullanimi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentDescription extends Fragment {

    TextView txtAciklama;
    String[] aciklamalar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_description,container,false);
        txtAciklama=v.findViewById(R.id.txtAciklama);
        aciklamalar=getResources().getStringArray(R.array.descriptions);
        txtAciklama.setText(aciklamalar[0]);
        return  v;
    }

    public void konuyuYukle(int position){
        txtAciklama.setText(aciklamalar[position]);
    }
}

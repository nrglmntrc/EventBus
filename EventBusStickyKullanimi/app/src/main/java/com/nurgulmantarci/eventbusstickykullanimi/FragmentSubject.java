package com.nurgulmantarci.eventbusstickykullanimi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nurgulmantarci.eventbusstickykullanimi.EventModels.PositionEvent;

import org.greenrobot.eventbus.EventBus;

public class FragmentSubject extends Fragment implements AdapterView.OnItemClickListener {

    ListView subjectList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_subject,container,false);
        subjectList=v.findViewById(R.id.liste);

        ArrayAdapter adapter=ArrayAdapter.createFromResource(getActivity(),R.array.subjects,android.R.layout.simple_list_item_1);
        subjectList.setAdapter(adapter);
        subjectList.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Abone olan tüm sınıflar bu yayını dinler..
        EventBus.getDefault().postSticky(new PositionEvent(position));
    }
}

package com.example.uravnenie2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentStart extends Fragment implements Perehod, View.OnClickListener{
    public int a = 0;
    Activity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        Button btn = rootView.findViewById(R.id.btn_text);
        btn.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void fgMain(int number) {
    }
    @Override
    public void onClick(View view) {
        a++;
        try {
            ((Perehod) activity).fgMain(a);
        }catch (ClassCastException ignored){
        }
    }//счетчик нажатий
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof Activity){
            activity = (Activity) context;
        }
    }//работа с активностью страницы на которой вызывается фрагмент
}
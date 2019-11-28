package com.mgc.terminal.app;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.JDService;


public class JDFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        view=inflater.inflate(R.layout.fragment3, container, false);

        setLayout();

        return view;

    }
    public void setLayout(){
        Button startBtn=(Button) view.findViewById(R.id.jd_start);
        Button shutBtn=(Button) view.findViewById(R.id.jd_shut);
        Button socketBtnOn=(Button)view.findViewById(R.id.button);
        Button socketBtnOFF=(Button)view.findViewById(R.id.button2);
        Button lightBtnOn=(Button)view.findViewById(R.id.button3);
        Button lightBtnOFF=(Button)view.findViewById(R.id.button4);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"设备全开",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.onkeyStart();
            }
        });
        shutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"设备全关",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.onkeyClose();
            }
        });
        socketBtnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"插座全开",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.socketOnAndOFF("on");
            }
        });
        socketBtnOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"插座全关",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.socketOnAndOFF("off");
            }
        });
        lightBtnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"灯光全开",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.lightOnAndOFF("on");
            }
        });
        lightBtnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"灯光全关",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.lightOnAndOFF("off");
            }
        });
    }

}

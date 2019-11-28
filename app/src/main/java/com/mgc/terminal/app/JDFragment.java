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
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"开启电源",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.onkeyStart();
            }
        });
        shutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"关闭电源",Toast.LENGTH_SHORT).show();
                JDService jdService=new JDService();
                jdService.onkeyClose();
            }
        });
    }

}

package com.mgc.terminal.app;

import android.os.Bundle;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.main_activity);
    }
}

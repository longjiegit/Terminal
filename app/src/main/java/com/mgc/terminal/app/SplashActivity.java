package com.mgc.terminal.app;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.DataInit;
import com.mgc.terminal.bean.SingletData;
import com.mgc.terminal.db.DBHelper;


public class SplashActivity extends AppCompatActivity {
    private int id;
    private String url;
    private String password;
    private int port;
    public EditText ipAndPort;
    public EditText pwdText;
    public Button loginBtn;
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.splash);
        ipAndPort=findViewById(R.id.account_input);
        pwdText=findViewById(R.id.password_input);
        loginBtn=findViewById(R.id.btn_login);
        final ProgressDialog progressDialog =new ProgressDialog(SplashActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // 设置ProgressDialog 标题
        progressDialog.setTitle("数据初始化");

        // 设置ProgressDialog 提示信息
        progressDialog.setMessage("数据加载中……");

        // 设置ProgressDialog 的进度条是否不明确
        progressDialog.setIndeterminate(false);

        // 设置ProgressDialog 是否可以按退回按键取消
        progressDialog.setCancelable(true);
        progressDialog.setButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int i)
            {
                //点击“取消”按钮取消对话框
                dialog.cancel();
            }
        });

        // 让ProgressDialog显示
        progressDialog.show();

        Handler handler = new Handler() {
            // 但有新消息时调用
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 200) {
//                    Intent it=new Intent(SplashActivity.this,MainAct.class);//启动MainActivity
//                    startActivity(it);
//                    finish();
                }else if(msg.what==404){
                    progressDialog.setTitle("数据初始化");
                    progressDialog.setMessage("数据加载失败，请检查网络...");

                }
            }
        };
        DBHelper helper=DBHelper.getInstance(SplashActivity.this);
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query("servurl",new String[]{"url","port","password"},null,null,null,null,null);
        if(cursor.moveToFirst()){
           // id=cursor.getInt(cursor.getColumnIndex("id"));
            url=cursor.getString(cursor.getColumnIndex("url"));
            port=cursor.getInt(cursor.getColumnIndex("port"));
            password=cursor.getString(cursor.getColumnIndex("password"));
            System.out.println(url+port+password);
        }
        ipAndPort.setText(url+":"+port);
        ipAndPort.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ipAndPort.setFocusableInTouchMode(true);
                return false;
            }
        });
        pwdText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pwdText.setFocusableInTouchMode(true);
                return false;
            }
        });
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    String pwd = pwdText.getText().toString();
//                    System.out.println("密码" + pwd);
//                    if (!"".equals(pwd)) {
//                        if (pwd.equals(password)) {
//                            SingletData.getInstance().setIp(url);
//                            SingletData.getInstance().setPort(port);
//                            //ip和port是否有变
//                            String t = ipAndPort.getText().toString();
//
//                            String t2 = url + ":" + port;
//                            if (!t2.equals(t)) {
//                                DBHelper helper2 = DBHelper.getInstance(SplashActivity.this);
//                                SQLiteDatabase db2 = helper2.getWritableDatabase();
//                                String[] ts = t.split(":");
//                                ContentValues contentValues = new ContentValues();
//                                contentValues.put("url", ts[0]);
//                                contentValues.put("port", Integer.parseInt(ts[1]));
//                                db2.update("servurl",contentValues,null,null);
//
//                                Intent it = new Intent(SplashActivity.this, MainAct.class);//启动MainActivity
//                                startActivity(it);
//                                finish();
//                            } else {
//                                Intent it = new Intent(SplashActivity.this, MainAct.class);//启动MainActivity
//                                startActivity(it);
//                                finish();
//                            }
//
//                        }else{
//                            Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
//                    }
//                }catch (Exception e){
//
//                }
//            }
//        });
        DataInit d=new DataInit(progressDialog,handler,url,port);
        d.start();


    }
}

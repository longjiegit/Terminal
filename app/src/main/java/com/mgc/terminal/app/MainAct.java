package com.mgc.terminal.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.mgc.terminal.R;



public class MainAct extends FragmentActivity {
    // private Handler handler;
    private ViewPager fragmentViewPager;
    private ListView leftListView;
    private List<Fragment> fragmentlist;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private JDFragment jdFragment;
    private VideoFragment videoFragment;
    private ArrayList<String> leftlist = new ArrayList<String>();// left list
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.act_main);
        fragmentViewPager = (ViewPager) findViewById(R.id.fragmentViewPager);
        leftListView = (ListView) findViewById(R.id.leftListView);
        initDatas();// left初始化。
        initDatasViewPager();
        System.out.println("-------------");





        // aTextViewCallBack back = (aTextViewCallBack)
        // findViewById(R.id.aTextViewCallBack);
        // back.setCalBack(new calBack() {
        // @Override
        // public void onclick() {
        // // TODO Auto-generated method stub
        // Toast.makeText(MainActivity.this, "这是回调的点击事件哦~",
        // Toast.LENGTH_LONG).show();
        // }
        // });
        //
        // new Thread(new Runnable() {
        //
        // @Override
        // public void run() {
        // // TODO Auto-generated method stub
        // String str = "http://www.easyicon.net/";
        // String st = getHtmlByURL.getHtmlByURL(str);
        // Message msg = handler.obtainMessage(0,st);
        // handler.sendMessage(msg);
        // }
        // }).start();
        // handler = new Handler() {
        // public void handleMessage(Message msg) {
        // super.handleMessage(msg);
        // String x = msg.obj.toString();
        // Log.i("GEtHtml", x);
        // };
        // };
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---------main start_________");
    }

    public void initDatas() {
//        for (int i = 0; i < 5; i++) {
//            leftlist.add("第" + i + "个");
//            Log.i("65", leftlist.get(i).toString());
//        }
        leftlist.add("终端");
        leftlist.add("投影");
        leftlist.add("强电控制");
        leftlist.add("播放控制");

        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < leftlist.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("lefttitle", leftlist.get(i).toString());
            listitems.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, listitems,
                R.layout.leftlistview_item, new String[] { "lefttitle" },
                new int[] { R.id.leftTitleTextView });

        leftListView.setAdapter(adapter);
        // listview点击事件
        leftListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                fragmentViewPager.setCurrentItem(position);

            }
        });
    }

    public void initDatasViewPager() {
        fragmentlist = new ArrayList<Fragment>();
        fragment1 = new Fragment1();//
        fragment2 = new Fragment2();//
        jdFragment=new JDFragment();
        videoFragment=new VideoFragment();
        fragmentlist.add(fragment1);
        fragmentlist.add(fragment2);
        fragmentlist.add(jdFragment);
        fragmentlist.add(videoFragment);
        adapter= new FragmentAdapter(
                getSupportFragmentManager(), fragmentlist, this);
        fragmentViewPager.setAdapter(adapter);
        fragmentViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

    }

    // set OnPageChangeListener in inner class
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            // last
            switch (arg0) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
            }
        }

    }
}

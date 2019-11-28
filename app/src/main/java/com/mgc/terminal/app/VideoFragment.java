package com.mgc.terminal.app;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.mgc.terminal.R;
import com.mgc.terminal.adapter.VideoAdapter;
import com.mgc.terminal.bean.SingletData;
import com.mgc.terminal.bean.VideoBean;


import java.util.List;

public class VideoFragment extends Fragment {
    private ListView mGridView;
    View view;
    List<VideoBean> mArrayList;
    private VideoAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment2, container, false);
        mGridView = (ListView) view.findViewById(R.id.gridview2);
        initdata();// 数据
        adapter = new VideoAdapter(view.getContext(),mArrayList );
        setLayout();


        return view;
    }
    private void initdata() {
        // TODO Auto-generated method stub
        mArrayList = SingletData.getInstance().getVds();

    }
    private void setLayout(){
        if (mGridView == null) {
            mGridView = (ListView) view. findViewById(R.id.gridview2);
        }
        mGridView.setVisibility(View.VISIBLE);
        mGridView.setSelection(0);
        mGridView.setAdapter(adapter);

    }
}

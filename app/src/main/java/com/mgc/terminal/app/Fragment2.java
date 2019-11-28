package com.mgc.terminal.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.mgc.terminal.R;
import com.mgc.terminal.adapter.TouyingAdapter;
import com.mgc.terminal.bean.BtnBean;
import com.mgc.terminal.bean.SingletData;

import java.util.List;

public class Fragment2 extends Fragment {
	private GridView mGridView;
	View view;
	List<BtnBean> mArrayList;
	private TouyingAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment2, container, false);
		mGridView = (GridView) view.findViewById(R.id.gridview2);
		adapter = new TouyingAdapter(view.getContext(), SingletData.getInstance().getTys());
		setLayout();
		initdata();// 数据

		return view;
	}
	private void initdata() {
		// TODO Auto-generated method stub
		mArrayList = SingletData.getInstance().getTys();

	}
	private void setLayout(){
		if (mGridView == null) {
			mGridView = (GridView)view. findViewById(R.id.gridview2);
		}
		mGridView.setVisibility(View.VISIBLE);
		mGridView.setSelection(0);
		mGridView.setAdapter(adapter);

	}
}

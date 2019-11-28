package com.mgc.terminal.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.mgc.terminal.R;
import com.mgc.terminal.adapter.MyAdapter;
import com.mgc.terminal.bean.BtnBean;
import com.mgc.terminal.bean.SingletData;
import java.util.List;

public class Fragment1 extends Fragment {
	private ListView mGridView;
	View view;
	List<BtnBean> mArrayList;
	private MyAdapter adapter;
	Handler handler;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view=inflater.inflate(R.layout.fragment1, container, false);
		mGridView = (ListView) view.findViewById(R.id.gridview1);
		adapter = new MyAdapter(view.getContext(), SingletData.getInstance().getBtns());
		setLayout();

		initdata();// 数据

		return view;

	}


	private void initdata() {
		// TODO Auto-generated method stub

		mArrayList = SingletData.getInstance().getBtns();


//		for (int i = 0; i < 20; i++) {
//			mArrayList.add(new BtnBean("项目"+i,"192.168","11-11"));
//		}
	}
	private void setLayout(){
		if (mGridView == null) {
			mGridView = (ListView) view. findViewById(R.id.gridview1);
		}
		mGridView.setVisibility(View.VISIBLE);

		//mGridView.setOnItemClickListener(view.getContext());

		mGridView.setSelection(0);
//		List<Map<String,Object>> listItems=new ArrayList<Map<String,Object>>();
//		for(int i=0;i<7;i++){
//			Map<String,Object> listItem=new HashMap<String,Object>();
//			listItem.put("name","abc"+i);
//
//			listItems.add(listItem);
//		}
//		SimpleAdapter sAdapter = new SimpleAdapter(view.getContext(), listItems, R.layout.items,
//				new String[] {"name"}, new int[] {
//				R.id.textView1});
		mGridView.setAdapter(adapter);

	}


}
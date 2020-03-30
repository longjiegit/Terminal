package com.mgc.terminal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mgc.terminal.R;

import java.util.List;

public class LeftListViewAdapter extends BaseAdapter {
    private List<String> mArrayList=null;
    private LayoutInflater mInflater = null;
    private Context mContext;
    public LeftListViewAdapter(Context context,List<String> list){
        mContext=context;
        mArrayList=list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mArrayList == null ? 0 : mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList == null ? null : mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        System.out.println("abacd:"+MainAct.mPosition);
//        System.out.println("aaaa:"+position);
//        TextView label=null;
//        System.out.println(convertView);
//        if(convertView==null){
//            convertView = mInflater.from(mContext).inflate(R.layout.leftlistview_item, parent, false);
//
//        }
//        label=(TextView)convertView.findViewById(R.id.leftTitleTextView);
//        label.setText((String)getItem(position));
//        LinearLayout l=(LinearLayout)convertView.findViewById(R.id.leftlayout);
//        if(position== MainAct.mPosition){
//            l.setBackgroundResource(R.drawable.left_textview_bg);
//        }else {
//            l.setBackgroundResource(R.drawable.left_textview_bg_noselect);
//        }
        return convertView;
    }
}

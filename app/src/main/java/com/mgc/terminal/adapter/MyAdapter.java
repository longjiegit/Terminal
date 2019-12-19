package com.mgc.terminal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.mgc.terminal.R;
import com.mgc.terminal.Service.ComputService;
import com.mgc.terminal.bean.BtnBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private Context mContext;
    private List<BtnBean> mArrayList = null;

    public MyAdapter(Context context, List<BtnBean> arrayList) {
        mContext = context;
        mArrayList = arrayList;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mArrayList == null ? 0 : mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mArrayList == null ? null : mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder = null;
        final BtnBean mBean = (BtnBean) getItem(position);
        if (convertView == null) {
            convertView = mInflater.from(mContext).inflate(R.layout.items, parent, false);
            holder = new ViewHolder();
//            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
//            //holder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            holder.cNum = (TextView) convertView.findViewById(R.id.c_num);
            holder.cLabel = (TextView) convertView.findViewById(R.id.c_label);
            holder.cIP = (TextView) convertView.findViewById(R.id.c_ip);
            holder.start = (Button) convertView.findViewById(R.id.btn_start);
            holder.shutdown = (Button) convertView.findViewById(R.id.btn_shutdown);
            //注意这里是个坑，如果写在这里的话，listview中会出现item重复显示的bug，
            //本人当时由于写错了,在这里走了冤枉了
            //holder.imageView.setImageResource(mBean.getImageId());
            //holder.textView.setText(mBean.getIconName());
            holder.start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"开启主机",Toast.LENGTH_SHORT).show();
                    ComputService c=new ComputService();
                    c.startByControl(mBean.getMac());
                }
            });
            holder.shutdown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"关闭主机",Toast.LENGTH_SHORT).show();
                    ComputService c=new ComputService();
                    c.ShutDownByControl(mBean.getIP());
                }
            });
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.cNum.setText(String.valueOf(position+1));
        holder.cLabel.setText(mBean.getLabel());
        holder.cIP.setText(mBean.getIP());
        holder.start.setText("开机");
        holder.shutdown.setText("关机");
        return convertView;
    }


class ViewHolder {
        TextView cNum;
        TextView cLabel;
        TextView cIP;
        TextView cMac;
        Button start;
        Button shutdown;
}

}

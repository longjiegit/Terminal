package com.mgc.terminal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.VideoService;
import com.mgc.terminal.bean.VideoBean;

import java.util.List;


public class VideoAdapter extends BaseAdapter {
    private LayoutInflater mInflater = null;
    private Context mContext;
    private List<VideoBean> mArrayList = null;

    public VideoAdapter(Context context, List<VideoBean> arrayList) {
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
        ViewHolder holder=null;
        final VideoBean mBean = (VideoBean) getItem(position);
        if (convertView == null) {
            convertView = mInflater.from(mContext).inflate(R.layout.videoitems, parent, false);
            holder = new ViewHolder();
//            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
//            //holder.imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            holder.name = (TextView) convertView.findViewById(R.id.video_name);
            holder.play = (Button) convertView.findViewById(R.id.video_start);
            holder.stop = (Button) convertView.findViewById(R.id.video_stop);
            holder.voice=(SeekBar)convertView.findViewById(R.id.video_voice);
            //注意这里是个坑，如果写在这里的话，listview中会出现item重复显示的bug，
            //本人当时由于写错了,在这里走了冤枉了
            //holder.imageView.setImageResource(mBean.getImageId());
            //holder.textView.setText(mBean.getIconName());
            holder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"播放影片",Toast.LENGTH_SHORT).show();
                    VideoService vs=new VideoService();

                    vs.contorVideo(mBean.getNum(),"play");

                }
            });
            holder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"停止播放",Toast.LENGTH_SHORT).show();
                    VideoService vs=new VideoService();
                    vs.contorVideo(mBean.getNum(),"stop");

                }
            });
            holder.voice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    VideoService vs=new VideoService();
                    vs.contorVideo(mBean.getNum(),"voice,"+progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.name.setText(mBean.getName());
        holder.play.setText("播放/暂停");
        holder.stop.setText("停止");
        return convertView;
    }


    class ViewHolder {

        TextView name;
        Button play;
        Button stop;
        SeekBar voice;
    }
}

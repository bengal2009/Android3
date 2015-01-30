package com.example.lin.android3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by blin on 2015/1/30.
 */
public   class CustomListAdapter extends BaseAdapter {
    private ArrayList<NewsItem> listData;
    private LayoutInflater layoutInflater;
    public CustomListAdapter(Context context, ArrayList<NewsItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);

    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custlist, null);
            holder = new ViewHolder();
            holder.TitleView = (TextView) convertView.findViewById(R.id.Title1);
            holder.AddrView = (TextView) convertView.findViewById(R.id.addr);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.TitleView.setText(listData.get(position).getTitle());
        holder.AddrView.setText("By, " + listData.get(position).getAddress());

        return convertView;
    }
    static class ViewHolder {
        TextView TitleView;
        TextView AddrView;
    }

}

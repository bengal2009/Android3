package com.example.lin.android3;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainList_chk extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
//        Start
        ArrayList<NewsItem> image_details = getListData();
        final ListView lv1 = (ListView) findViewById(R.id.listView12);
        lv1.setAdapter(new CustomListAdapter(this, image_details));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                NewsItem newsData = (NewsItem) o;
                Toast.makeText(MainList_chk.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();

            }

        });
    }
    private ArrayList<NewsItem> getListData() {
        ArrayList<NewsItem> results = new ArrayList<NewsItem>();
        int i;
        for(i=0;i<10;i++) {
            NewsItem newsData = new NewsItem();
            newsData.setTitle("Dance of Democracy:"+i);
            newsData.setAddress("Pankaj Gupta");
            newsData.setChecked(false);
            results.add(newsData);
        }
        return results;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 private static class CustomListAdapter extends BaseAdapter {
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
                convertView = layoutInflater.inflate(R.layout.custlist_chk, null);
                holder = new ViewHolder();
                holder.TitleView = (TextView) convertView.findViewById(R.id.Title1);
                holder.AddrView = (TextView) convertView.findViewById(R.id.addr);
                holder.ChkView = (CheckBox) convertView.findViewById(R.id.chkb1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.TitleView.setText(listData.get(position).getTitle());
            holder.AddrView.setText("By, " + listData.get(position).getAddress());
            holder.ChkView.setChecked( listData.get(position).getChecked());
            return convertView;
        }
        static class ViewHolder {
            TextView TitleView;
            TextView AddrView;
            CheckBox ChkView;
        }

    }

 private static class NewsItem {
        private String Title;
        private String Address;
        private boolean checked;

        public String getTitle(){
            return Title;
        }
        public String getAddress(){
            return Address;
        }
     public void setChecked(boolean checked) {
         this.checked = checked;
     }
        public void setTitle(String title  )
        {
            this.Title=title;
        }
        public boolean getChecked() {
         return checked;
        }
        public void setAddress(String address)
        {
            this.Address=address;
        }
        @Override
        public String toString(){
            return Title+":"+Address+":"+checked;
        }
    }
}

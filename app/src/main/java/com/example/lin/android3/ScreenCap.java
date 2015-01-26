package com.example.lin.android3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;


public class ScreenCap extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_cap);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screen_cap, menu);
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

    private void printScreen(boolean save) {//截屏

        View view = this.getWindow().getDecorView();//this是当前的Activity
        // if (view.isDrawingCacheEnabled()) {
        view.setDrawingCacheEnabled(true);
        Calendar c = Calendar.getInstance();
        String date = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + "  " + c.get(Calendar.HOUR_OF_DAY) + "-" + c.get(Calendar.MINUTE) + "-" + c.get(Calendar.SECOND);
        // }
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        String imagePath = Environment.getExternalStorageDirectory() + "/" + date + ".jpg";//路径
        writePhotoJpg(bmp, imagePath);
        // FileSaveAsync myAsync = new FileSaveAsync(bmp, imagePath, true);
        // myAsync.execute();
    }
    public void writePhotoJpg(Bitmap data, String pathName) {
        File file = new File(pathName);
        try {
            file.createNewFile();
            // BufferedOutputStream os = new BufferedOutputStream(
            // new FileOutputStream(file));

            FileOutputStream os = new FileOutputStream(file);
            data.compress(Bitmap.CompressFormat.JPEG, 100, os);
            os.flush();
            os.close();
//            MyDebug.i("writePhotoJpg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writePhotoPng(Bitmap data, String pathName) {
        File file = new File(pathName);
        try {
            file.createNewFile();
            FileOutputStream os = new FileOutputStream(file);
            // BufferedOutputStream os = new BufferedOutputStream(
            // new FileOutputStream(file));
            data.compress(Bitmap.CompressFormat.PNG, 100, os);
            os.flush();
            os.close();
//            MyDebug.i("writePhotoPng");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

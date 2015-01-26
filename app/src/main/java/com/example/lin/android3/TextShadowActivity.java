package com.example.lin.android3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TextShadowActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_text_shadow);
        setContentView(new drawCanvas(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_shadow, menu);
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
    class drawCanvas extends View
    {
        private Bitmap bitmap = null;
        public drawCanvas(Context context)
        {
            super(context);
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.abc_ab_share_pack_holo_dark);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            // 建立Paint 物件
            Paint paint1 = new Paint();
            // 设定颜色
            paint1.setColor(0xFFFFFF00);
            // 设定阴影(柔边, X 轴位移, Y 轴位移, 阴影颜色)
            paint1.setShadowLayer(5, 3, 3, 0xFFFF00FF);
            // 实心矩形& 其阴影
            canvas.drawText("我很爱你", 20,40,paint1);
            Paint paint2 = new Paint();
            paint2.setColor(Color.GREEN);
            paint2.setShadowLayer(10, 5, 2, Color.YELLOW);
            canvas.drawText("你真傻", 20,60,paint2 );

            Paint paint3 = new Paint();
            paint3.setColor(Color.RED);
            paint3.setShadowLayer(30, 5, 2, Color.GREEN);
            canvas.drawCircle(50, 130,30, paint3);

            Paint paint4 = new Paint();
            paint4.setShadowLayer(5, 8, 7, Color.DKGRAY);
            canvas.drawBitmap(bitmap, 50, 200, paint4);
        }
    }

}


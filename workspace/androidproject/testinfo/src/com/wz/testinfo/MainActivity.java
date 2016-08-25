package com.wz.testinfo;

import java.util.concurrent.CountDownLatch;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	private Button bt;
	private TimeCount time;
	///实现发送验证码并计时60s
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = new TimeCount(60000, 1000);
        bt = (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				time.start();
			}
		});
    }
    class TimeCount extends CountDownTimer{

		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			bt.setText("重新获取验证码");
			bt.setClickable(true);
			bt.setBackgroundColor(Color.parseColor("#4EB84A"));
			
		}

		@Override
		public void onTick(long millsUntifinished) {
			// TODO Auto-generated method stub
			bt.setBackgroundColor(Color.parseColor("#B6B6D8"));
			bt.setClickable(false);
			bt.setText("("+millsUntifinished/1000+")秒后可重新发送");
		}
    	
    }


   
}

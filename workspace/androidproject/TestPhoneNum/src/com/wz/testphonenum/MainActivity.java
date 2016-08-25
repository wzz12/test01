package com.wz.testphonenum;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	Button bt;
	String phNum,phPsw,name,indeNum;
	EditText etphnum,etphpsw,etname,etidennum;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*
		 * 在主程序操作前加上如下代码
		 * 主要原因是，android4.0以后的版本不允许在主程序中进行联网操作，否则会报错误
		 */
		//StrictMode主要用来检查网络访问，若出问题会警告
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
		//如果不指定检测函数，也可以用detectAll()替代
		.detectDiskReads()
		.detectDiskWrites()
		.detectNetwork() // or .detectAll() for all detectable problems
		//penaltyLog()表示将警告输出到logcat
		.penaltyLog()
		.build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
		.detectLeakedSqlLiteObjects()
		.detectLeakedClosableObjects()
		.penaltyLog()
		/*
		 * 也可以使用其他或增加新的惩罚（penalty）函数，例如使用penaltyDeath()的话，
		 * 一旦StrictMode消息被写到LogCat后应用就会崩溃
		 */
		.penaltyDeath()
		.build());
		//这一大堆都是
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		bt=(Button) findViewById(R.id.bt);
		//要访问的网址
		String httpUrl="https://www.baidu.com/";
		String resultDataString="";
		URL url=null;
		try {
			url=new URL(httpUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		}
		if(url!=null){
			//打开一个HttpURLConnection连接
			try {
				HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		initialize();
	
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*实现点击按钮进入百度页面
				Uri uri = Uri.parse("http://www.baidu.com");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);*/
				
			}
		});
	}
	//初始化信息

	private void initialize() {
		// TODO Auto-generated method stub
		etphnum=(EditText) findViewById(R.id.phN);
		etphpsw=(EditText) findViewById(R.id.phPas);
		etname=(EditText) findViewById(R.id.etName);
		etidennum=(EditText) findViewById(R.id.etid);
		//取得输入框中的信息
		phNum=etphnum.getText().toString();
		phPsw=etphpsw.getText().toString();
		name=etname.getText().toString();
		indeNum=etidennum.getText().toString();
		
		
	}

    
   
}

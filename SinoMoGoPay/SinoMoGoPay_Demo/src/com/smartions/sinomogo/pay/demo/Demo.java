package com.smartions.sinomogo.pay.demo;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.smartions.sinomogo.countly.Countly;
import com.smartions.sinomogo.pay.openapi.IAppExit;
import com.smartions.sinomogo.pay.openapi.PayService;
import com.smartions.sinomogo.pay.openapi.PayService.IBackgroundMusic;

public class Demo extends Activity {
	private GridView gvProduct;
	private EditText etCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.pay_demo);

		init();
	}

	private void init(){
		gvProduct = (GridView) findViewById(R.id.gv_product);
		etCount = (EditText) findViewById(R.id.etCount);

		//生成动态数组，并且转入数据  
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
		for(int i=1;i<=40;i++)  
		{  
			HashMap<String, Object> map = new HashMap<String, Object>();  
			map.put("productid", "com.smartions.sinomogo.test.product"+i);
			map.put("productprice",i+".00" );//产品价格
			map.put("productname","Product"+i );//产品名称
			lstImageItem.add(map);  
		}  
		ItemAdapter adapter = new ItemAdapter(this, lstImageItem,etCount);
		gvProduct.setAdapter(adapter);
	}

	@Override
	protected void onStart() {
		super.onStart();

		HashMap<String, String> segmentation = new HashMap<String, String>();
		segmentation.put("EVENT1", "Item1");
		segmentation.put("EVENT2", "Item1");

		Countly.sharedInstance().recordEvent("CustomEvent", segmentation, 1);
	}



	@Override
	protected void onStop() {
		super.onStop();
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}

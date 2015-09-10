package com.smartions.sinomogo.pay.demo;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.smartions.sinomogo.pay.openapi.ParentPayReceiver;
import com.smartions.sinomogo.pay.openapi.Platform;

public class PayResultIntentReceiver extends ParentPayReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		//Obtain transaction result
		
		if(RESULT_FLAG){ //Transaction Successfully
			//Obtain payment platforms
			Platform platform = Platform.valueOf(PAY_WAY);
			switch(platform){
			case alipayclient:
				//Alipay
				toast(context);
				break;

			case unionpay:
				//UnionPay
				toast(context);
				break;

			default:
				break;

			}
		}else{ //Transaction failure
			toast(context);
		}
	}
	public void toast(Context context){
		Toast.makeText(context, "<SinoMoGoPay>:"+"productId:=" + PRODUCT_ID + ",resultFlag:=" + RESULT_FLAG + ",payWay:=" + PAY_WAY, Toast.LENGTH_LONG).show();
	}
}


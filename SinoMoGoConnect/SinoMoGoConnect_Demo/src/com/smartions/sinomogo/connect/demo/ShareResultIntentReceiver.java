package com.smartions.sinomogo.connect.demo;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.smartions.sinomogo.connect.openapi.ParentConnectReceiver;
import com.smartions.sinomogo.connect.openapi.Platform;


public class ShareResultIntentReceiver extends ParentConnectReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		
		if (SHARE_FLAG) { 	//shareSuccess
			
			//Obtain sharing platforms
			Platform platform = Platform.valueOf(SHARE_TYPE);
			switch(platform){
			case sina:
				//SINA Weibo
				toastM(context);
				break;
			case tencent:
				//TENCENT Weibo
				toastM(context);
				break;
			case renren:
				//RENREN
				toastM(context);
				break;
			case friend:
				//WeChat friend
				toastM(context);
				break;
			case group:
				//WeChat Moments
				toastM(context);
				break;
				
			}

		}else {
			toastM(context);
		}
	}
	
	public void toastM(Context context){
		Toast.makeText(context,"<SinoMoGoConnect>:"+SHARE_TYPE+"--"+SHARE_FLAG,Toast.LENGTH_LONG).show();
	}
}

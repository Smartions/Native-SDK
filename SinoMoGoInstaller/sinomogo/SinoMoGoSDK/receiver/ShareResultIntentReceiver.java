package MainPackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.smartions.sinomogo.connect.openapi.ParentConnectReceiver;
import com.smartions.sinomogo.connect.openapi.Platform;


public class ShareResultIntentReceiver extends ParentConnectReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);

		//Obtain connect result
		if (SHARE_FLAG) { 	//shareSuccess

			//Obtain sharing platforms
			Platform platform = Platform.valueOf(SHARE_TYPE);
			switch(platform){
			case sina:
				
				break;
			case tencent:

				break;
			case renren:

				break;
			case friend:
				
				break;
			case group:

				break;
			default:
				break;
			}
			//Share awards
			Log.d("sinomogo", "sinomogoShare success: "+SHARE_TYPE);
		}else {
			
			Log.d("sinomogo", "sinomogoShare failure: "+SHARE_TYPE);
		}
	}
}

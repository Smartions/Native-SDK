package MainPackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.smartions.sinomogo.pay.openapi.ParentPayReceiver;
import com.smartions.sinomogo.pay.openapi.Platform;

public class PayResultIntentReceiver extends ParentPayReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		
		//Obtain transaction result
		if(RESULT_FLAG){//Transaction Successfully
			
			//Obtain payment method
			Platform platform = Platform.valueOf(PAY_WAY);
			switch(platform){
				case alipayclient:

					break;

				case unionpay:

					break;

				default:
					break;
			}
			//Pay awards
			Log.d("sinomogo", "sinomogoPay success: "+PAY_WAY+"--"+PRODUCT_ID);
		}else{
			//Transaction failure
			Log.d("sinomogo", "sinomogoPay failure: "+PAY_WAY+"--"+PRODUCT_ID);
		}
		
	}
}

package com.smartions.sinomogo.pay.demo;

import android.app.Application;
import android.content.Context;

public class SinomogoAppcation extends Application {
	  @Override
	  protected void attachBaseContext(final Context base) {
		  super.attachBaseContext(base);
	  }
	  @Override
	  public void onCreate() {
		try {
			System.loadLibrary("sinomogo");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{}
	}
}
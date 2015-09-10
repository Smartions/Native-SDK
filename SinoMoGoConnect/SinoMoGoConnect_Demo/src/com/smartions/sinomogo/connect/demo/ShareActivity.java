package com.smartions.sinomogo.connect.demo;


import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.smartions.sinomogo.connect.demo.tool.CopyFileFromAssets;
import com.smartions.sinomogo.connect.openapi.SNSType;
import com.smartions.sinomogo.connect.openapi.ShareService;
import com.smartions.sinomogo.countly.Countly;


public class ShareActivity extends Activity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;

		CopyFileFromAssets.copy(this, "share.jpg", CopyFileFromAssets.saveFilesDir, "share.jpg");
		CopyFileFromAssets.copy(this, "qq.png", CopyFileFromAssets.saveFilesDir, "qq.png");
		CopyFileFromAssets.copy(this, "renren.png", CopyFileFromAssets.saveFilesDir, "renren.png");
		CopyFileFromAssets.copy(this, "sina.png", CopyFileFromAssets.saveFilesDir, "sina.png");
		CopyFileFromAssets.copy(this, "friend.png", CopyFileFromAssets.saveFilesDir, "friend.png");
		CopyFileFromAssets.copy(this, "group.png", CopyFileFromAssets.saveFilesDir, "group.png");

	}


	/**
	 * 显示定制的分享按钮点击事件 
	 */
	public void toShare(View v) {

		String content = "这是测试的部分分享内容";
		String imagePath = CopyFileFromAssets.saveFilesDir+"/share.jpg";
		String wechatPath = CopyFileFromAssets.saveFilesDir+"/group.png";
		String url="http://www.sinomogo.com";
		/**
		 * content:分享的内容
		 * imagePath:分享的图片路径 ，存储在手机本地路径，如果没有图片，则填写null
		 * url:分享链接地址
		 * 注：如果在AndroidManifest.xml中配置了微信分享选项，需要填写url分享链接地址，
		 * 如果只配置了 新浪微博、腾讯微博或者人人，则url为null
		 */
		ShareService.getInstance().shareAction(mContext,content,imagePath,wechatPath, SNSType.ALL,url);
	}

	/**
	 * 新浪微博分享按钮点击事件 
	 */
	public void toSina(View v){
		String content = "这是测试的新浪微博分享内容";
		String imagePath = CopyFileFromAssets.saveFilesDir+"/sina.png";
		ShareService.getInstance().shareAction(mContext, content, imagePath,null, SNSType.SINA, null);

	}

	/**
	 * 腾讯微博分享按钮点击事件 
	 */
	public void toTencent(View v){
		String content = "这是测试的腾讯微博分享内容";
		String imagePath = CopyFileFromAssets.saveFilesDir+"/qq.png";
		ShareService.getInstance().shareAction(mContext, content, imagePath, null,SNSType.TENCENT, null);
	}

	/**
	 * 人人分享按钮点击事件 
	 */
	public void toRenRen(View v){
		String content = "这是测试的人人分享内容";
		String imagePath = CopyFileFromAssets.saveFilesDir+"/renren.png";
		ShareService.getInstance().shareAction(mContext, content, imagePath,null, SNSType.RENREN, null);
	}

	/**
	 * 微信好友分享按钮点击事件 
	 */
	public void toFriend(View v){
		String content = "这是测试的微信好友分享内容";
		String friendPath = CopyFileFromAssets.saveFilesDir+"/friend.png";
		String url="http://www.sinomogo.com";
		ShareService.getInstance().shareAction(mContext, content, null,friendPath, SNSType.FRIEND, url);
	}

	/**
	 * 微信朋友圈分享按钮点击事件 
	 */
	public void toGroup(View v){
		String content = "这是测试的微信朋友圈分享内容";
		String groupPath = CopyFileFromAssets.saveFilesDir+"/group.png";
		String url="http://www.sinomogo.com";
		ShareService.getInstance().shareAction(mContext, content,null,groupPath, SNSType.GROUP, url);
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

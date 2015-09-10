package com.smartions.sinomogo.pay.demo;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smartions.sinomogo.pay.openapi.PayService;

public class ItemAdapter extends BaseAdapter {

	private ArrayList<HashMap<String, Object>> list;
	private Context mContext;
	private LayoutInflater inflater;
	private EditText etCount;
	
	public ItemAdapter(Context context,ArrayList<HashMap<String, Object>> l,EditText et){
		this.mContext = context;
		this.list = l;
		this.etCount = et;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		
		
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.pay_item, null);
			
			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
			holder.btBuy = (Button) convertView.findViewById(R.id.btnBuy);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.tvName.setText(list.get(position).get("productname").toString());
		holder.tvPrice.setText(list.get(position).get("productprice").toString());
		
		holder.btBuy.setOnClickListener(new OnClick(list.get(position).get("productid").toString()));
		
		return convertView;
	}
	
	class OnClick implements OnClickListener{

		private String productdId;
		
		public OnClick(String id){
			this.productdId = id;
		}
		
		@Override
		public void onClick(View v) {
			int count = Integer.valueOf(etCount.getText().toString());
//			Log.d("", "-->count:"+count+",productdId:"+productdId);
			if (count < 1) {
				count = 1;
			}
			try {
				
				PayService.getInstance().purchase(mContext, productdId,count);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public class ViewHolder{
		public TextView tvName;
		public TextView tvPrice;
		public Button btBuy;
	}

}

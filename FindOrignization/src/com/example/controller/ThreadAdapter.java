package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Tiezi;
import com.example.zhaozuzhi.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadAdapter extends ArrayAdapter<Thread> {

	private ArrayList<Tiezi> entries;
    private Activity activity;
    
    public ThreadAdapter(Activity activity, int textViewResourceId, ArrayList<Tiezi> entries) {
        super(activity, textViewResourceId, (List) entries);
        this.entries = (ArrayList<Tiezi>)entries;
        this.activity = activity;
    }
    
    
    
    /**
     * Make the view for listview
     */
	public static class ViewHolder{
        public TextView item1; 
        public TextView item2; 
        public TextView item3;	
        public TextView item4;
        public ImageView imageview;
    }
	
	
	
	/**
	 * Put the data into the  view
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater vi =
                (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.listlayout, null);
            holder = new ViewHolder();
            
            holder.item1 = (TextView) view.findViewById(R.id.textView1);
            /*
            holder.item2 = (TextView) view.findViewById(R.id.smalll);
            holder.item3 = (TextView) view.findViewById(R.id.loca);
            holder.item4 = (TextView) view.findViewById(R.id.number);
            holder.imageview = (ImageView) view.findViewById(R.id.imageView88);
            */
            view.setTag(holder);
        }
        else
            holder=(ViewHolder)view.getTag();
 
        final Tiezi custom = entries.get(position);
        if (custom != null) {
        	/*DecimalFormat format = new DecimalFormat("###.#");
            holder.item1.setText(custom.getThe_comment());
            holder.item2.setText(custom.getSubject_comment());
            holder.item3.setText(format.format(custom.getDistance())+"m");
            holder.item4.setText(custom.getUserName());
            if(custom.getImage_encode()!=null)
            {   
            	BitmapConverter ImageConvter = new BitmapConverter();
            	Bitmap bitmap = ImageConvter.deserialize(custom.getImage_encode(), null, null);
            	
            	if(bitmap!=null)
                {
                	holder.imageview.setImageBitmap(bitmap);
                }
            	
            }
            else
            {
            	holder.imageview.setImageBitmap(null);
            }*/
            
        }
        return view;
    }
	
}

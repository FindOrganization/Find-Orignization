package com.example.zhaozuzhi;

import java.util.ArrayList;

import com.example.controller.ThreadAdapter;
import com.example.model.Tiezi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
/**
 * This class the main view for the Comments
 * @author Bill
 *
 */
public class ThreadFragment extends Fragment{
	
	private ListView listView;
	private ThreadAdapter threadAdapter;
	private ArrayList<Tiezi> TieziList = new ArrayList<Tiezi>();
	private Tiezi testItem = new Tiezi();
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(com.example.zhaozuzhi.R.layout.fragment_thread,container,false);
		TieziList.add(testItem);
		listView = (ListView) view.findViewById(com.example.zhaozuzhi.R.id.listView1);
		threadAdapter = new ThreadAdapter(this.getActivity(), com.example.zhaozuzhi.R.layout.listlayout, TieziList);
		listView.setAdapter(threadAdapter);
		threadAdapter.notifyDataSetChanged();
		return view;
	}
	
	
	
	

	

}

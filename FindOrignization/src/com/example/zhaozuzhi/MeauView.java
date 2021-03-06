package com.example.zhaozuzhi;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MeauView extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] birds = getResources().getStringArray(R.array.birds);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, birds);
		setListAdapter(colorAdapter);
	}
	
	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = new CommentsFragment(position);
		if(position==0)
		{
			switchFragment(new ThreadFragment());
		}
		else if  (newContent != null){
			switch(position){
			case 0:
				switchFragment(new ThreadFragment());
				break;
			case 1:
				switchFragment(new ThreadFragment());
				break;
			case 2:
				switchFragment(new ThreadFragment());
				break;
			case 3:
				switchFragment(new ThreadFragment());
				break;
			case 4:
				switchFragment(new ThreadFragment());
				break;
	
			}
		}
			
	}
	
	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;

		if (getActivity() instanceof MainPageActivity) {
			MainPageActivity ra = (MainPageActivity) getActivity();
			ra.switchContent(fragment);
		}
	}

}

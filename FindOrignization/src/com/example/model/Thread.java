package com.example.model;

import java.util.ArrayList;
import java.util.Date;

import android.graphics.Bitmap;

public class Thread {
	
		private String title="";
		private String content="";
		private int numberOfViews=0;
		private Date dateCreated; // need to fetch server date and time
		private int ID;
		private Bitmap image;
		private ArrayList<Bitmap> images;
		private User author;
		private int likes=0;
		private int unlikes=0;
		private long longitude;
		private long latitude;
		// need to finish constructor 
		public Thread()
		{
			
		}
}

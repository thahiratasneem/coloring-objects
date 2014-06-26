package com.manish.sqlite;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {
	ArrayList<Image> imageArry = new ArrayList<Image>();
	Field[] fields = R.drawable.class.getFields();
	ArrayList<Image> uimageArry = new ArrayList<Image>();
	Field[] ufields = R.drawable.class.getFields();
	List<Integer> drawables = new ArrayList<Integer>();
	List<Integer> udrawables = new ArrayList<Integer>();
	ImageAdapter adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		DataBaseHandler db = new DataBaseHandler(this);
		// get image from drawable
		for (Field field : fields) {
	        // Take only those with name starting with "fr"
	        if (field.getName().startsWith("img")) {
	            try {
					drawables.add(field.getInt(null));
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }
		// get image from drawable
				for (Field field : fields) {
			        // Take only those with name starting with "fr"
			        if (field.getName().startsWith("uimag")) {
			            try {
							udrawables.add(field.getInt(null));
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			    }
		for(int i=0;i<drawables.size() && i<udrawables.size();i++)
		{
		Bitmap image = BitmapFactory.decodeResource(getResources(),
				drawables.get(i));
		Bitmap uimage = BitmapFactory.decodeResource(getResources(),
				udrawables.get(i));

		// convert bitmap to byte
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		byte imageInByte[] = stream.toByteArray();
		ByteArrayOutputStream ustream = new ByteArrayOutputStream();
		uimage.compress(Bitmap.CompressFormat.JPEG, 100, ustream);
		byte uimageInByte[] = ustream.toByteArray();
		/**
		 * CRUD Operations
		 * */
		// Inserting Contacts
		Log.d("Insert: ", "Inserting ..");
		db.addContact(new Image(imageInByte, uimageInByte));
		}
		// display main List view bcard and contact name

		// Reading all contacts from database
		List<Image> contacts = db.getAllContacts();
		for (Image cn : contacts) {
			String log = "ID:" + cn.getID() + " Image: " + cn.getImage()
					+ " ,UImage: " + cn.getUImage();

			// Writing Contacts to log
			Log.d("Result: ", log);
			//add contacts data in arrayList
			imageArry.add(cn);

		}
		adapter = new ImageAdapter(this, R.layout.screen_list,
				imageArry);
		ListView dataList = (ListView) findViewById(R.id.list);
		dataList.setAdapter(adapter);

	}

}
package edu.stts;

import android.app.Activity;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.TypedValue;

public class PhotoSpot extends Activity {

	public void onCreate(Bundle b) {
		super.onCreate(b);
		getFragmentManager()
			.beginTransaction()
			.replace(android.R.id.content, new Login())
			.commit();
	}

	public Bitmap loadBitmap(String name) {
		try {
			return BitmapFactory.decodeStream(getAssets().open(name));
		} catch (Exception e) {
			return null;
		}
	}

	public int dpToPx(float dp) {
		return (int) TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_DIP,
			dp,
			getResources().getDisplayMetrics()
		);
	}
}

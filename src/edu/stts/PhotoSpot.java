package edu.stts;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.TypedValue;
import android.util.Log;
import android.widget.ImageView;

import java.util.HashMap;
import android.graphics.drawable.ColorDrawable;

public class PhotoSpot extends Activity {

	private HashMap<String, Bitmap> cache = new HashMap<>();

	public void onCreate(Bundle b) {
		getWindow().setBackgroundDrawable(new ColorDrawable(0xffffffff));
		super.onCreate(b);
		getFragmentManager()
			.beginTransaction()
			.replace(android.R.id.content, new Main())
			.commit();
	}

	public void push(Fragment fragment) {
		getFragmentManager()
			.beginTransaction()
			.replace(android.R.id.content, fragment)
			.addToBackStack(null)
			.commit();
	}

	public void replace(int target, Fragment fragment) {
		getFragmentManager()
			.beginTransaction()
			.replace(target, fragment)
			.commit();
	}

	public void loadBitmapTo(final ImageView view, final String name) {
		view.post(new Runnable() {
			public void run() {
				try {
					String key = name + "-" + view.getWidth() + "-" + view.getHeight();
					Bitmap cached = cache.get(key);
					if (cached == null) {
						BitmapFactory.Options options = new BitmapFactory.Options();
						options.inJustDecodeBounds = true;
						BitmapFactory.decodeStream(getAssets().open(name), null, options);
						options.inJustDecodeBounds = false;
						options.inSampleSize = 1;
						if (options.outWidth > view.getWidth() || options.outHeight > view.getHeight()) {
							int halfWidth = options.outWidth / 2;
							int halfHeight = options.outHeight / 2;
							while ((halfWidth / options.inSampleSize) >= view.getWidth()
									&& (halfHeight / options.inSampleSize) >= view.getHeight()) {
								options.inSampleSize *= 2;
							}
						}
						cached = BitmapFactory.decodeStream(getAssets().open(name), null, options);
						cache.put(key, cached);
					}
					view.setImageBitmap(cached);
				} catch (Exception e) {
					Log.e("PhotoSpot", "loadBitmapTo() failed.", e);
				}
			}
		});
	}

	public int dpToPx(float dp) {
		return (int) TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_DIP,
			dp,
			getResources().getDisplayMetrics()
		);
	}
}

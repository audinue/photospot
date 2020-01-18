package edu.stts;

import android.app.Activity;
import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

public class PlaceUtil {

	public static View createThumbnails(Activity activity) {
		LinearLayout layout = new LinearLayout(activity);
		int topPadding = ((PhotoSpot) activity).dpToPx(5);
		layout.setPadding(0, topPadding, 0, 0);
		int bottomMargin = ((PhotoSpot) activity).dpToPx(10);
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		layout.setOrientation(LinearLayout.VERTICAL);
		String[] images = new String[] {
			"a.jpg", "b.jpg", "c.jpg",
			"d.jpg", "e.jpg", "f.jpg",
		};
		int columnCount = 3;
		int rowCount = (int) Math.ceil((float) images.length / columnCount);
		int height = ((PhotoSpot) activity).dpToPx(60);
		int n = 0;
		for (int i = 0; i < rowCount; i++) {
			LinearLayout row = new LinearLayout(activity);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(0, 0, 0, bottomMargin);
			row.setLayoutParams(params);
			for (int j = 0; j < columnCount; j++) {
				if (j == 1) {
					row.addView(createSpace(activity));
				}
				ImageView view = new ImageView(activity);
				view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height, 1));
				view.setScaleType(ImageView.ScaleType.CENTER_CROP);
				if (n < images.length) {
					view.setBackgroundColor(0xffdddddd);
					((PhotoSpot) activity).loadBitmapTo(view, images[n]);
					n++;
				}
				row.addView(view);
				if (j == 1) {
					row.addView(createSpace(activity));
				}
			}
			layout.addView(row);
		}
		return layout;
	}

	private static View createSpace(Activity activity) {
		ImageView view = new ImageView(activity);
		int width = ((PhotoSpot) activity).dpToPx(10);
		view.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
		return view;
	}
}

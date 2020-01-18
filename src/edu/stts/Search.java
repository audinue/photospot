package edu.stts;

import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Search extends FragmentBase {

	public View createView() {
		ImageView image = new ImageView(getActivity());
		image.setScaleType(ImageView.ScaleType.CENTER_CROP);
		((PhotoSpot) getActivity()).loadBitmapTo(image, "map.jpg");
		return image;
	}
}

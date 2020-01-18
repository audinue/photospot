package edu.stts;

import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.graphics.Typeface;

public class Home extends FragmentBase {

	public View createView() {
		ScrollView scroll = new ScrollView(getActivity());
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		int padding = ((PhotoSpot) getActivity()).dpToPx(10);
		layout.setPadding(padding, padding, padding, padding);
		layout.addView(createRecommendedPlaces());
		layout.addView(createNearbyPlaces());
		scroll.addView(layout);
		return scroll;
	}

	private View createRecommendedPlaces() {
		LinearLayout layout = new LinearLayout(getActivity());
		int padding = ((PhotoSpot) getActivity()).dpToPx(20);
		layout.setPadding(0, 0, 0, padding);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(createGroupTitle("Recommended Places"));
		layout.addView(createSelectRegion());
		layout.addView(PlaceUtil.createThumbnails(getActivity()));
		return layout;
	}

	private View createNearbyPlaces() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(createGroupTitle("Nearby Places"));
		layout.addView(PlaceUtil.createThumbnails(getActivity()));
		return layout;
	}

	private View createSelectRegion() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setGravity(Gravity.CENTER);
		layout.addView(createSelectRegionLabel());
		layout.addView(createSelectRegionName());
		layout.addView(createSelectRegionSpace());
		layout.addView(createSelectRegionButton());
		return layout;
	}

	private View createSelectRegionLabel() {
		TextView text = new TextView(getActivity());
		int padding = ((PhotoSpot) getActivity()).dpToPx(5);
		text.setPadding(0, 0, padding, 0);
		text.setText("Select Region:");
		return text;
	}

	private View createSelectRegionSpace() {
		TextView text = new TextView(getActivity());
		text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		return text;
	}

	private View createSelectRegionName() {
		TextView text = new TextView(getActivity());
		text.setText("Jawa Timur");
		text.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
		return text;
	}

	private View createSelectRegionButton() {
		Button button = new Button(getActivity());
		button.setText("Change");
		button.setMinWidth(0);
		button.setMinHeight(0);
		button.setMinimumWidth(0);
		button.setMinimumHeight(0);
		return button;
	}

	private View createGroupTitle(String name) {
		TextView text = new TextView(getActivity());
		text.setText(name);
		text.setTextSize(12);
		text.setTextColor(0xffaaaaaa);
		return text;
	}
}

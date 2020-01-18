package edu.stts;

import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main extends FragmentBase {

	private LinearLayout footer;

	private void setCurrent(int index) {
		if (footer != null) {
			for (int i = 0; i < footer.getChildCount(); i++) {
				footer.getChildAt(i)
					.setBackgroundColor(
						i == index
							? 0xffffffff
							: 0
					);
			}
			((PhotoSpot) getActivity()).replace(1,
				index == 0
					? new Home()
					: index == 1
						? new Search()
						: index == 2
							? new Community()
							: new Profile()
			);
		}
	}

	public View createView() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(createHeader());
		layout.addView(createBody());
		layout.addView(createFooter());
		setCurrent(0);
		return layout;
	}

	private View createHeader() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setGravity(Gravity.CENTER_VERTICAL);
		int padding = ((PhotoSpot) getActivity()).dpToPx(10);
		layout.setPadding(padding, padding, padding, padding);
		layout.addView(createLogoImage());
		layout.addView(createLogoText());
		return layout;
	}

	private View createBody() {
		FrameLayout layout = new FrameLayout(getActivity());
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		layout.setId(1);
		return layout;
	}

	private View createFooter() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setBackgroundColor(0xffeeeeee);
		layout.addView(createButton("ic_home_black_48dp.png", "Home"));
		layout.addView(createButton("ic_search_black_48dp.png", "Search"));
		layout.addView(createButton("ic_chat_black_48dp.png", "Community"));
		layout.addView(createButton("ic_person_black_48dp.png", "Profile"));
		footer = layout;
		return layout;
	}

	private View createLogoImage() {
		ImageView image = new ImageView(getActivity());
		int size = ((PhotoSpot) getActivity()).dpToPx(30);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
		int margin = ((PhotoSpot) getActivity()).dpToPx(5);
		params.setMargins(0, 0, margin, 0);
		image.setLayoutParams(params);
		((PhotoSpot) getActivity()).loadBitmapTo(image, "ic_photo_camera_black_48dp.png");
		return image;
	}

	private View createLogoText() {
		TextView text = new TextView(getActivity());
		text.setText("PhotoSpot");
		text.setTextSize(30);
		return text;
	}

	private View createButton(String image, String text) {
		LinearLayout layout = new LinearLayout(getActivity());
		int padding = ((PhotoSpot) getActivity()).dpToPx(10);
		layout.setPadding(padding, padding, padding, padding);
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		layout.setGravity(Gravity.CENTER);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(createButtonImage(image));
		layout.addView(createButtonLabel(text));
		layout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				setCurrent(footer.indexOfChild(view));
			}
		});
		return layout;
	}

	private View createButtonImage(String image) {
		ImageView view = new ImageView(getActivity());
		int size = ((PhotoSpot) getActivity()).dpToPx(24);
		view.setLayoutParams(new LinearLayout.LayoutParams(size, size));
		((PhotoSpot) getActivity()).loadBitmapTo(view, image);
		return view;
	}

	private View createButtonLabel(String text) {
		TextView view = new TextView(getActivity());
		view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		view.setText(text);
		return view;
	}
}
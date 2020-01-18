package edu.stts;

import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends FragmentBase {

	public View createView() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(createTop());
		layout.addView(createBottom());
		return layout;
	}

	private View createTop() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		layout.setGravity(Gravity.CENTER);
		layout.addView(createLogo());
		return layout;
	}

	private View createBottom() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
		layout.setGravity(Gravity.CENTER);
		layout.addView(createLoginButton());
		return layout;
	}

	private View createLogo() {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setGravity(Gravity.CENTER);
		layout.addView(createLogoImage());
		layout.addView(createLogoText());
		return layout;
	}

	private View createLogoImage() {
		ImageView image = new ImageView(getActivity());
		int size = ((PhotoSpot) getActivity()).dpToPx(32);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
		int margin = ((PhotoSpot) getActivity()).dpToPx(5);
		params.setMargins(0, 0, margin, 0);
		image.setLayoutParams(params);
		image.setImageBitmap(((PhotoSpot) getActivity()).loadBitmap("ic_photo_camera_black_48dp.png"));
		return image;
	}

	private View createLogoText() {
		TextView text = new TextView(getActivity());
		text.setText("PhotoSpot");
		text.setTextSize(32);
		return text;
	}

	private View createLoginButton() {
		Button button = new Button(getActivity());
		button.setText("Login");
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				getActivity().getFragmentManager()
					.beginTransaction()
					.replace(android.R.id.content, new Home())
					.addToBackStack(null)
					.commit();
			}
		});
		return button;
	}
}
package edu.stts;

import android.view.View;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends FragmentBase {

	public View createView() {
		LinearLayout layout = new LinearLayout(getActivity());
		TextView text = new TextView(getActivity());
		text.setText("HOME");
		layout.addView(text);
		return layout;
	}
}
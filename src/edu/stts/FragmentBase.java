package edu.stts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.widget.LinearLayout;

public abstract class FragmentBase extends Fragment {

	private View view;

	public abstract View createView();

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle b) {
		if (view == null) {
			view = createView();
		}
		return view;
	}
}
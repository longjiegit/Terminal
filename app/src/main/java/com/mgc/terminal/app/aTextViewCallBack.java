package com.mgc.terminal.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class aTextViewCallBack extends TextView {
	public calBack back;

	public aTextViewCallBack(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setCalBack(calBack back) {
		this.back = back;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (back != null) {
			back.onclick();
		}
		return super.onTouchEvent(event);
	}

	public interface calBack {
		public void onclick();
	}
}

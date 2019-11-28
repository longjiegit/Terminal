package com.mgc.terminal.app;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

import com.mgc.terminal.R;

public class MyView extends View {
	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void onDraw(Canvas canvas) {

		Paint paint_blue = new Paint(); // 绘制蓝色的环
		paint_blue.setColor(Color.BLUE);
		paint_blue.setStyle(Style.STROKE);
		paint_blue.setStrokeWidth(10);
		canvas.drawCircle(110, 150, 60, paint_blue);

		Paint paint_yellow = new Paint(); // 绘制黄色的环
		paint_yellow.setColor(Color.YELLOW);
		paint_yellow.setStyle(Style.STROKE);
		paint_yellow.setStrokeWidth(10);
		canvas.drawCircle((float) 175.5, 210, 60, paint_yellow);

		Paint paint_black = new Paint(); // 绘制黑色的环
		paint_black.setColor(Color.BLACK);
		paint_black.setStyle(Style.STROKE);
		paint_black.setStrokeWidth(10);
		canvas.drawCircle(245, 150, 60, paint_black);

		Paint paint_green = new Paint(); // 绘制绿色的环
		paint_green.setColor(Color.GREEN);
		paint_green.setStyle(Style.STROKE);
		paint_green.setStrokeWidth(10);
		canvas.drawCircle(311, 210, 60, paint_green);

		Paint paint_red = new Paint(); // 绘制红色的环
		paint_red.setColor(Color.RED);
		paint_red.setStyle(Style.STROKE);
		paint_red.setStrokeWidth(10);
		canvas.drawCircle(380, 150, 60, paint_red);

		Paint paint_string = new Paint(); // 绘制字符串
		paint_string.setColor(Color.BLUE);
		paint_string.setTextSize(20);
		canvas.drawText("Welcome to Beijing", 245, 310, paint_string);

		Paint paint_line = new Paint(); // 绘制直线
		paint_line.setColor(Color.BLUE);
		canvas.drawLine(240, 310, 425, 310, paint_line);

		Paint paint_text = new Paint(); // 绘制字符串
		paint_text.setColor(Color.BLUE);
		paint_text.setTextSize(20);
		canvas.drawText("北京欢迎您", 275, 330, paint_text);

		// 绘制福娃图片
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher), 35, 340, paint_line);
	}
}

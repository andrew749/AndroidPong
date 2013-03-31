package com.andrew749.androidpong;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GameView extends View {
	private static Ball ball;
	private static Paddle paddle;
	private static int userX;
	private static int userY;
	private List<Ball> balls;
	private Context application;
	public GameView(Context context, int displayX, int displayY) {
		super(context);
		application=context;
		paddle = new Paddle(context, displayX, displayY);
		ball = new Ball(context, displayX, displayY);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paddle.update(canvas, userX);
		ball.update(canvas, paddle);
		if (!ball.getAliveOrNot()){
			
		}
		invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
			userX = (int) event.getX();
			break;
		}
		return true;
	}

}

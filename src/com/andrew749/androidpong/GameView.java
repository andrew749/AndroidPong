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
	private static Paddle paddlePlayer1;
	private static Brick[] brick;
	private static int userX;
	private static int userY;
	private Context application;
	private Canvas c;
	int x = 0;

	public GameView(Context context, int displayX, int displayY) {
		super(context);
		application = context;
		brick = new Brick[100];
		paddlePlayer1 = new Paddle(context, displayX, displayY, 1);
		ball = new Ball(context, displayX, displayY);
		for (int i = 0; i < 10; i++) {
			brick[i] = new Brick(x, 0, 1);
			x += 40;

		}

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		for (int i = 0; i < 10; i++) {
			brick[i].update(canvas);
		}
		paddlePlayer1.update(canvas, userX);
		ball.update(canvas, paddlePlayer1);
		if (!ball.getAliveOrNot()) {
			// do somethign to penalize the player
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

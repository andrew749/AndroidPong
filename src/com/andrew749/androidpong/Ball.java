package com.andrew749.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
	private static int ballRadius = 5;
	private static int ballSpeed = 3;
	private static int xSpeed = 1;
	private static int ySpeed = 1;
	private static int ballX = 1;
	private static int ballY = 1;
	private static Paint paint;
	private static int screenX, screenY;

	public Ball(Context context, int displayX, int displayY) {
		paint = new Paint();
		paint.setColor(Color.RED);
		screenX = displayX;
		screenY = displayY;
	}

	public void update(Canvas canvas) {
		if (wallCollisionX()){xSpeed*=-1;}
		if (wallCollisionY()){ySpeed*=-1;}
		ballX += xSpeed;
		ballY += ySpeed;
		
		drawBall(canvas);
	}

	public void drawBall(Canvas canvas) {
		canvas.drawCircle(ballX, ballY, ballRadius, paint);
	}

	public boolean wallCollisionX() {
		if (ballX >= screenX || ballX <= 0) {
			return true;
		}
		 else {
			return false;
		}
	}
	public boolean wallCollisionY(){
		if (ballY >= screenY || ballY <= 0) {
			return true;
		}else {return false;}
	}
}

package com.andrew749.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Ball {
	private static int ballRadius = 5;
	private static int xSpeed = 5;
	private static int ySpeed = 5;
	private static int ballX = 1;
	private static int ballY = 1;
	private static Paint paint;
	private static int screenX, screenY;
	private Paddle paddleLocal;
	private Rect ball;
	public boolean alive=true;

	public Ball(Context context, int displayX, int displayY) {
		paint = new Paint();
		paint.setColor(Color.RED);
		screenX = displayX;
		screenY = displayY;
	}

	public void update(Canvas canvas, Paddle paddle) {
		ball = new Rect(ballX - ballRadius, ballY - (ballRadius), ballX
				+ ballRadius, ballY + ballRadius);
		if (wallCollisionX()) {
			xSpeed *= -1;
		}
		if (wallCollisionY()) {
			ySpeed *= -1;
		}
		if (collidedWithPaddle(paddle)) {
			ySpeed *= -1;
		}
		if (loseALife()) {
			xSpeed = 0;
			ySpeed = 0;
			alive=false;
		}
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
		} else {
			return false;
		}
	}

	public boolean wallCollisionY() {
		if (ballY >= screenY || ballY <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean loseALife() {
		if (ballY > paddleLocal.paddleObject().top) {
			return true;
		} else {
			return false;
		}
	}

	public boolean collidedWithPaddle(Paddle paddle) {
		paddleLocal = paddle;
		if (paddle.paddleObject().intersect(ball)) {
			paint.setColor(Color.GREEN);
			return true;
		} else {
			return false;
		}
	}
	public boolean getAliveOrNot(){
		return alive;
	}
}

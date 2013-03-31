package com.andrew749.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Ball {
	// the radius of the ball
	private static int ballRadius = 5;
	// the speed of the ball
	private static int xSpeed = 5;
	private static int ySpeed = 5;
	// the location that the ball will start at
	private static int ballX = 1;
	private static int ballY = 1;
	// the paint for the ball
	private static Paint paint;
	// the screen dimensions
	private static int screenX, screenY;
	// a paddle object to interact with the ball
	private Paddle paddleLocal;
	// a rectangle holding the dimensions of the ball
	private Rect ball;
	// holds the state of the game and whether the player is still alive
	public boolean alive = true;

	public Ball(Context context, int displayX, int displayY) {
		paint = new Paint();
		paint.setColor(Color.RED);
		screenX = displayX;
		screenY = displayY;
	}

	// updates the canvas and states
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
			alive = false;
		}
		ballX += xSpeed;
		ballY += ySpeed;
		drawBall(canvas);
	}

	// draws the ball
	public void drawBall(Canvas canvas) {
		canvas.drawCircle(ballX, ballY, ballRadius, paint);
	}

	// collisions of the horizontal plane
	public boolean wallCollisionX() {
		if (ballX >= screenX || ballX <= 0) {
			return true;
		} else {
			return false;
		}
	}

	// collisions on the vertical plane
	public boolean wallCollisionY() {
		if (ballY >= screenY || ballY <= 0) {
			return true;
		} else {
			return false;
		}
	}

	// determines if the ball is within play
	public boolean loseALife() {
		if (ballY > paddleLocal.paddleObject().top) {
			return true;
		} else {
			return false;
		}
	}

	// a method determining if the ball collides with the paddle
	public boolean collidedWithPaddle(Paddle paddle) {
		paddleLocal = paddle;
		if (paddle.paddleObject().intersect(ball)) {
			paint.setColor(Color.GREEN);
			return true;
		} else {
			return false;
		}
	}

	// returns whether the game is still playing or over
	public boolean getAliveOrNot() {
		return alive;
	}
}

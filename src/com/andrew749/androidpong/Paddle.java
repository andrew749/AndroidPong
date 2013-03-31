package com.andrew749.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Paddle {
	// dimensions of the paddle
	private static int paddleHeight = 10;
	private static int paddleWidth = 100;
	// the speed of the paddle moving across the screen
	private static int paddleSpeed = 7;
	// the x and y coordinates of the paddle
	private static int paddleX = 0;
	private static int paddleY = 0;
	// the destination coordinate that the paddle is moving to
	private static int moveToX;
	private static int moveToY;
	// the paddle paint
	private static Paint paint;
	// the rectangle object that is the paddle
	protected Rect paddleBox;
	// screen dimensions
	private static int screenX;
	private static int screenY;

	public Paddle(Context context, int displayX, int displayY, int typeOfPaddle) {
		paint = new Paint();
		paint.setColor(Color.BLUE);
		paddleBox = new Rect();
		screenX = displayX;
		screenY = displayY;
		/*
		 * typeOfPaddle is a variable that will control the position of the
		 * paddle and whether it will be placed at the top of the screen or at
		 * the bottom
		 * 
		 * a state of 1 is normal with the paddle at the bottom a state of 2
		 * will be at the top of the screen
		 * 
		 * It is also placed in here so that the game can be expanded to use all
		 * 4 corners of the screen and to change the game from pong to something
		 * else
		 */
		if (typeOfPaddle == 1) {
			paddleY = displayY;
			paddleY -= paddleHeight;
		} else if (typeOfPaddle == 0) {
		}
	}

	// this method will take the user input and move the paddle to the
	// appropriate location
	// it will also draw the paddle using the other method defined in this
	// application
	protected void update(Canvas canvas, int userX) {
		userX -= (int) (paddleWidth / 2);
		moveToX = userX;
		if (paddleX < moveToX - 10) {
			paddleX += paddleSpeed;
		} else if (paddleX > moveToX + 10) {
			paddleX -= paddleSpeed;
		}
		createRectangle();
		drawPaddle(canvas);
	}

	/*
	 * this class will create the rectangle obejct it is cruicial so that the
	 * paddle interacts with the ball
	 * 
	 * This method also limits the paddle so that it cannot move past the bounds
	 * of the screen
	 */
	private void createRectangle() {
		limitPaddle();
		paddleBox.set(paddleX, paddleY, paddleX + paddleWidth, paddleY
				+ paddleHeight);
	}

	/*
	 * This method draws the rectangle holding the dimensions of the paddle
	 */
	protected void drawPaddle(Canvas canvas) {
		canvas.drawRect(paddleBox, paint);
	}

	/*
	 * this method limits the paddles coordinates so that it stays within the
	 * bounds of the screen
	 */
	public void limitPaddle() {
		if (paddleX + paddleWidth > screenX) {
			paddleX = screenX - paddleWidth;
		} else if (paddleX < 0) {
			paddleX = 0;
		}
	}

	/*
	 * This method returns a rectangle object so that the ball class can
	 * interact with the paddle
	 */
	public Rect paddleObject() {
		return paddleBox;
	}
}

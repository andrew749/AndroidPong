package com.andrew749.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Paddle {
	private static int paddleHeight = 10;
	private static int paddleWidth = 100;
	private static int paddleSpeed = 7;
	private static int paddleX = 0;
	private static int paddleY = 0;
	private static int moveToX;
	private static int moveToY;
	private static Paint paint;
	protected Rect paddleBox;

	public Paddle(Context context, int displayX, int displayY){
	paint=new Paint();
	paint.setColor(Color.BLUE);
	paddleBox=new Rect();
	paddleY=displayY;
	paddleY-=paddleHeight;
	
}

	protected void update(Canvas canvas, int userX) {
		moveToX = userX;
		if (paddleX < moveToX - 10) {
			paddleX += paddleSpeed;
		} else if (paddleX > moveToX + 10) {
			paddleX -= paddleSpeed;
		}
		createRectangle();
		drawPaddle(canvas);
	}

	private void createRectangle() {
		paddleBox.set(paddleX, paddleY, paddleX + paddleWidth, paddleY
				+ paddleHeight);
	}

	protected void drawPaddle(Canvas canvas) {
		canvas.drawRect(paddleBox, paint);
	}
}

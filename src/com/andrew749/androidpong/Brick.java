package com.andrew749.androidpong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Brick {
	private static int brickHeight = 20;
	public static int brickWidth = 40;
	private static int brickType;
	private static Rect brick;
	private static int state;
	private static Paint brickColor;
	private static int durability=0;
	/*
	 * type will determine the type of brick that will be formed there will also
	 * be different bricks showing the durability of a brick
	 */
	public Brick(int x, int y, int type) {
		brickType = type;
		brick = new Rect();
		brickColor = new Paint();
		brick.set(x, y, x + brickWidth, y + brickHeight);
		switch (brickType) {
		case 1:
			brickColor.setColor(Color.BLUE);
			durability = 1;
			break;
		case 2:
			brickColor.setColor(Color.RED);
			durability = 2;
			break;
		}
	}

	public void drawBrick(Canvas canvas) {
		canvas.drawRect(brick, brickColor);
	}

	public void update(Canvas canvas) {
		if(durability==0){
			brickColor.setColor(Color.RED);
		}else{
			drawBrick(canvas);
		}
	}

	public Rect getBrick() {
		return brick;
	}
}

package com.andrew749.androidpong;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends Activity {
private static int displayX;
private static int displayY;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		displayX=getDisplayX();
		displayY=getDisplayY();
		Button startGame = (Button) findViewById(R.id.button1);
		startGame.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GameView game = new GameView(getApplicationContext(),displayX, displayY);
				setContentView(game);
				finish();
			}
		});
	}

	public int getDisplayX() {
		int displayX;
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		displayX = metrics.widthPixels;
		return displayX;
	}

	public int getDisplayY() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int displayY = metrics.heightPixels;
		return displayY;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

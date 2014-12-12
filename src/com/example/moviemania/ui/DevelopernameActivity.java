package com.example.moviemania.ui;

import com.example.moviemania.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class DevelopernameActivity extends Activity{

	Animation animsliderightin, animslideleftin;
	TextView title, name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_developername);
	
	title = (TextView) findViewById(R.id.textView2);
	name = (TextView) findViewById(R.id.textView1);
	
	animslideleftin = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.slideleftin);
	animsliderightin = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.sliderightin);
	
	title.startAnimation(animslideleftin);
	name.startAnimation(animsliderightin);
	
	}

}

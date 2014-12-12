package com.example.moviemania.ui;

import java.util.ArrayList;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moviemania.R;
import com.example.moviemania.model.Movie;
import com.example.moviemania.services.GenericSeeker;
import com.example.moviemania.services.MovieSeeker;

public class MainActivity extends ListActivity{
	
	private GenericSeeker<Movie> movieSeeker = new MovieSeeker();
	
	private ArrayList<Movie> moviesList;
	private MoviesAdapter moviesAdapter;
	ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	MovieSearchTask task = new MovieSearchTask();
	task.execute();
	
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	Intent i = new Intent(getApplicationContext(), DevelopernameActivity.class);
	startActivity(i);
	}

	private class MovieSearchTask extends AsyncTask<String, Void, ArrayList<Movie>> {
   
		@Override
		protected ArrayList<Movie> doInBackground(String... strings) {
		
			
		return movieSeeker.find();
		
		}
		
		@Override
		protected void onPostExecute(final ArrayList<Movie> movieList) {
			
		//Toast.makeText(getApplicationContext(), R.string.message, Toast.LENGTH_LONG).show();
		 moviesAdapter = new MoviesAdapter(MainActivity.this, R.layout.activity_movie_tab, movieList);
		 setListAdapter(moviesAdapter);
		
			}
		}
	
	

}

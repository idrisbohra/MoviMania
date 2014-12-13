package com.example.moviemania.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviemania.R;
import com.example.moviemania.model.Movie;
import com.example.moviemania.services.HttpRetriever;


public class MoviesAdapter extends ArrayAdapter<Movie> {
	public ImageLoader imageLoader;
	private Activity context;
private ArrayList<Movie> movies;
private HttpRetriever httpRetriever = new HttpRetriever();
public MoviesAdapter(Context context, int resource, ArrayList<Movie> objects) {
super(context, resource, objects);
this.context = (Activity)context;
movies = objects;
imageLoader=new ImageLoader(context);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
View view = convertView;
if (view == null) {
view = context.getLayoutInflater().inflate(R.layout.activity_movie_tab, null);
}
Movie movie = movies.get(position);

if(movie != null){
	
TextView nameTextView = (TextView)view.findViewById(R.id.name_text_view);
nameTextView.setText(movie.name);

TextView ratingTextView = (TextView)view.findViewById(R.id.adult_text_view);

boolean a = movie.adult;
if(a == true){
	ratingTextView.setText("(A)");
} else{
	ratingTextView.setText("(U/A)");
}

TextView releaseDateTextView = (TextView)view.findViewById(R.id.released_text_view);
releaseDateTextView.setText(movie.released);

ImageView imageView = (ImageView)view.findViewById(R.id.movie_thumb_icon);

String url = movie.retrieveThumbnailUrl();

imageLoader.DisplayImage(url, imageView);

}
return view;
}

}


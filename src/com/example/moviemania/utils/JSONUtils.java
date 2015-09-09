package com.example.moviemania.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.moviemania.model.Movie;


public class JSONUtils {

public static ArrayList<Movie> parseMovieResponse(String jsonStr) {
try{

JSONObject jsonObject = new JSONObject(jsonStr);
JSONArray results = jsonObject.getJSONArray("results");
ArrayList<Movie> movies = new ArrayList<Movie>();
for(int i = 0; i < results.length(); i++){

	
	JSONObject result = results.getJSONObject(i);
	
Movie movie = new Movie();
movie.rating = result.getString("vote_average");
movie.adult = result.getBoolean("adult");
movie.id = result.getString("id");
movie.name = result.getString("title");
movie.originalName = result.getString("original_title");
movie.popularity = result.getString("popularity");
movie.released = result.getString("release_date");
movie.votes = result.getString("vote_count");
movie.posterPath = result.getString("poster_path");
movies.add(movie);

//
}
return movies;
}
catch(JSONException e){
e.printStackTrace();
}
return null;
}
}

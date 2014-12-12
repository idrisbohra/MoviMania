package com.example.moviemania.services;

import java.util.ArrayList;

import android.util.Log;

import com.example.moviemania.model.Movie;
import com.example.moviemania.utils.JSONUtils;

public class MovieSeeker extends GenericSeeker<Movie> {
private static final String MOVIE_SEARCH_PATH = "search/movie";

@Override
public ArrayList<Movie> find() {
return retrieveMoviesList();
}

@Override
public ArrayList<Movie> find(int maxResults) {
return retrieveFirstResults(retrieveMoviesList(), maxResults);
}

private ArrayList<Movie> retrieveMoviesList(){
String url = constructSearchUrl();
String response = httpRetriever.retrieve(url);
if(response == null)
{
Log.d(getClass().getSimpleName(), "Network error");
return null;
}

//Log.d(getClass().getSimpleName(), response);
return JSONUtils.parseMovieResponse(response);

}

@Override
public String retrieveSearchMethodPath() {
return MOVIE_SEARCH_PATH;
}
}
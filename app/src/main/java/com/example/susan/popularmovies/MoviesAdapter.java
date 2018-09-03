package com.example.susan.popularmovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MoviesAdapter extends BaseAdapter {

    public static final String MOVIE_BASE_URL="https://image.tmdb.org/t/p/w185";

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    private Context mContext;
    ArrayList<Movie> list;

    public MoviesAdapter(Context context, ArrayList<Movie> movieList){
        this.mContext = context;
        this.list = movieList;
    }
}

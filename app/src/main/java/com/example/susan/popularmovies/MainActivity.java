package com.example.susan.popularmovies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.susan.popularmovies.Utilities.NetworkUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //strings declaration
    String popularMovies;
    String topRatedMovies;

    //array lists to hold custom movies objects
    ArrayList<Movie> mPopularList;
    ArrayList<Movie> mTopTopRatedList;

    //new progressbar object and bind it to the view
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.INVISIBLE); //hide progress bar by default
    }


    public class FetchMovies extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            String popularMoviesURL = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=" + BuildConfig.API_KEY;

            String topRatedMoviesURL = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key="+BuildConfig.API_KEY;

            //initialize array lists
            mPopularList = new ArrayList<>();
            mTopTopRatedList = new ArrayList<>();

            return null;
        }

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressBar.setVisibility(View.INVISIBLE);
        }


    }

    private static final String TAG = NetworkUtils.class.getSimpleName();
}

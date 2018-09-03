package com.example.susan.popularmovies.Utilities;

import android.nfc.Tag;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import com.example.susan.popularmovies.Movie;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;


public class NetworkUtils {

    public static ArrayList<Movie> fetchData(String url) throws IOException {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            URL new_url = new URL(url); //create a url from a string
            HttpURLConnection connection = (HttpURLConnection) new_url.openConnection(); //open http connection to object
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            //read from the object
            String results = IOUtils.toString(inputStream);//convert input stream objects to strings
            parseJson(results, movies);
            inputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return movies;
    }

    private static void parseJson(String data, ArrayList<Movie> list) {
        try{
            JSONObject mainObject = new JSONObject(data);
            JSONArray resArray = mainObject.getJSONArray("results");
            //Getting the results object
            for (int i = 0; i < resArray.length(); i++){
                JSONObject jsonObject = resArray.getJSONObject(i);
                Movie movie = new Movie(); //new movie object
                movie.setId(jsonObject.getInt("id"));
                movie.setBackdropPath(jsonObject.getString("backdrop_path"));
                movie.setOriginalTitle(jsonObject.getString("original_title"));
                movie.setOverview(jsonObject.getString("overview"));
                movie.setPopularity(jsonObject.getDouble("popularity"));
                movie.setPosterPath(jsonObject.getString("poster_path"));
                movie.setReleaseDate(jsonObject.getString("release_date"));
                movie.setVoteAverage(jsonObject.getInt("vote_average"));
                movie.setVoteCount(jsonObject.getInt("vote_count"));
                movie.setTitle(jsonObject.getString("title"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "Error occured durin json parsing", e);
        }
    }
}

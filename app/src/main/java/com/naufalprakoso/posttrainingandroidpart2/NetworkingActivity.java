package com.naufalprakoso.posttrainingandroidpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.naufalprakoso.posttrainingandroidpart2.adapter.MovieAdapter;
import com.naufalprakoso.posttrainingandroidpart2.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkingActivity extends AppCompatActivity {

    private ArrayList<Movie> movies;
    private MovieAdapter adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);

        movies = new ArrayList<>();
        adapter = new MovieAdapter(this);

        recyclerView = findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        String url = "https://api.myjson.com/bins/chup8";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Movie movie = new Movie();
                        movie.setTitle(jsonObject.getString("title"));
                        movie.setRating(jsonObject.getDouble("rating"));
                        movie.setYear(jsonObject.getInt("releaseYear"));

                        movies.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter.setMovies(movies);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}

package com.example.moon.movie;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import MovieAdapter.MovieAdapter;
import MovieApi.Client;
import MovieApi.Service;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private MovieAdapter mMovieAdapter;
    private List<Movie> movieList;
    public static final String LOG_TAG = MovieAdapter.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = (RecyclerView) findViewById(R.id.my_recycler_view);
        movieList = new ArrayList<>();
        mMovieAdapter = new MovieAdapter(this, movieList);
        mMovieAdapter.notifyDataSetChanged();

        Client client = new Client();
        Service service = Client.getClient().create(Service.class);
        Call<Response> call = service.getPopularMovies(BuildConfig."6b2ec88806cbac0cd2088d8d6fe6c62a");
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<Movie> movies = response.body().getResults();
                mRecycleView.setAdapter(new MovieAdapter(getApplicationContext(), movies));
                mRecycleView.smoothScrollToPosition(0);

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("Error", t.getMessage());
                Toast.makeText(MainActivity.this, "ERROR FETCHING DATA!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.settings:
        return true;
        default:return super.onOptionsItemSelected(item);
        }

    }
}


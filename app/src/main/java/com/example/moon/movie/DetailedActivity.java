package com.example.moon.movie;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetailedActivity extends AppCompatActivity {
    TextView movieName, plotSynopsis, userRating, releaseDate;
    ImageView posterPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        posterPath = (ImageView) findViewById(R.id.im_display);

    }
}

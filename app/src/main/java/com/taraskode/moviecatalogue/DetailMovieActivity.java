package com.taraskode.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_FILM = "extra_film";
    TextView tvJudul, tvDescription, tvDate;
    ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        getSupportActionBar().setTitle("Detail Movie");

        tvJudul = findViewById(R.id.tv_detail_judul);
        tvDescription = findViewById(R.id.tv_detail_description);
        tvDate = findViewById(R.id.tv_detail_date);
        imgPoster = findViewById(R.id.img_detail_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_FILM);
        tvJudul.setText(movie.getJudulFilm());
        tvDescription.setText(movie.getDescription());
        tvDate.setText(movie.getDate());
        imgPoster.setImageResource(movie.getPoster());



    }
}

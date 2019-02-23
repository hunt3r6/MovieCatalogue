package com.taraskode.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_JUDUL = "extra_judul";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_POSTER = "extra_poster";
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

        String judul = getIntent().getStringExtra(EXTRA_JUDUL);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        String date = getIntent().getStringExtra(EXTRA_DATE);
        int poster = getIntent().getIntExtra(EXTRA_POSTER, 0);

        tvJudul.setText(judul);
        tvDescription.setText(description);
        tvDate.setText(date);
        imgPoster.setImageResource(poster);

    }
}

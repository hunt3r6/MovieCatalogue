package com.taraskode.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] dataJudul;
    String[] dataDescription;
    String[] dataDate;
    TypedArray dataPoster;
    MovieAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MovieAdapter(this);
        listView = findViewById(R.id.tv_list);
        listView.setAdapter(adapter);
        getSupportActionBar().setTitle("Movie Catalogue");

        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntentMovie = new Intent(MainActivity.this, DetailMovieActivity.class);
                detailIntentMovie.putExtra(DetailMovieActivity.EXTRA_JUDUL, dataJudul[i]);
                detailIntentMovie.putExtra(DetailMovieActivity.EXTRA_DESCRIPTION, dataDescription[i]);
                detailIntentMovie.putExtra(DetailMovieActivity.EXTRA_DATE, dataDate[i]);
                detailIntentMovie.putExtra(DetailMovieActivity.EXTRA_POSTER, dataPoster.getResourceId(i, -1));
                startActivity(detailIntentMovie);

            }
        });
    }

    private void addItem() {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setJudulFilm(dataJudul[i]);
            movie.setDate(dataDate[i]);
            movie.setDescription(dataDescription[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
    }


}

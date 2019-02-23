package com.taraskode.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        Movie movie = (Movie)getItem(i);
        TextView txtJudul = view.findViewById(R.id.tv_judul);
        TextView txtDate = view.findViewById(R.id.tv_date);
        TextView txtDescription = view.findViewById(R.id.tv_description);
        ImageView imgPoster = view.findViewById(R.id.img_poster);
        txtJudul.setText(movie.getJudulFilm());
        txtDate.setText(movie.getDate());
        txtDescription.setText(movie.getDescription());
        imgPoster.setImageResource(movie.getPoster());
        return view;
    }
}

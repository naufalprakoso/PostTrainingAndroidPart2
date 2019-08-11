package com.naufalprakoso.posttrainingandroidpart2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naufalprakoso.posttrainingandroidpart2.R;
import com.naufalprakoso.posttrainingandroidpart2.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTitle.setText(movies.get(position).getTitle());
        holder.txtRating.setText(movies.get(position).getRating().toString());
        holder.txtYear.setText(movies.get(position).getYear().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtRating, txtYear;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtRating = itemView.findViewById(R.id.txt_rating);
            txtYear = itemView.findViewById(R.id.txt_year);
        }
    }
}

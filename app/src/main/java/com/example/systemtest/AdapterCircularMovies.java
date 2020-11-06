package com.example.systemtest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AdapterCircularMovies extends RecyclerView.Adapter<AdapterCircularMovies.ViewHolder> {

    private int[] movies = {R.drawable.p1,R.drawable.p2,R.drawable.movie};
    private Context context;

    public AdapterCircularMovies(Context mContext){
        this.context = mContext;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_circle,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(movies[position])
                .apply(RequestOptions.circleCropTransform()
                .override(200,200))
                .into(holder.ivMovieImage);
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivMovieImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMovieImage = itemView.findViewById(R.id.ivMovieImage);
        }
    }
}

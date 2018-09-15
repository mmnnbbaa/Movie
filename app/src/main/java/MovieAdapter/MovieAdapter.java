package MovieAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moon.movie.Movie;
import com.example.moon.movie.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context context;
    private List<Movie> movieList;

    public MovieAdapter(Context mcontext, List<Movie> mmovieList) {
        this.context = mcontext;
        this.movieList = mmovieList;
    }


    @Override
    public MyViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_detials, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder holder, int position) {
        holder.mTextView.setText(movieList.get(position).getOriginaltitle());
        String vote = Double.toString(movieList.get(position).getVoteaverage());
        holder.mTextView.setText(vote);
        Picasso.with(context).
                load(movieList.get(position).getPosterpath()).
                placeholder(R.drawable.loading).into(holder.mImageView);

    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_display_details);
            mImageView = (ImageView) itemView.findViewById(R.id.im_display);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Movie clicked = movieList.get(position);
                        Intent intent = new Intent(context , DetailedActivity.class);
                        intent.putExtra("original_title",movieList.get(position).getOriginaltitle());
                        intent.putExtra("poster_path",movieList.get(position).getPosterpath());
                        intent.putExtra("overview",movieList.get(position).getOverview());
                        intent.putExtra("vote_average",Double.toString(movieList.get(position).getVoteaverage()));
                        intent.putExtra("release_date",movieList.get(position).getReleasedate());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}

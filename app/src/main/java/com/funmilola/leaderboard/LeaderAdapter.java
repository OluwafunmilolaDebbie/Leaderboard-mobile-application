package com.funmilola.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.ViewHolder> {

   private List<LearningModel> itemListLeader;
    private Context context;


    public LeaderAdapter(Context context, List<LearningModel> itemList) {
        this.context = context;
        this.itemListLeader = itemList;
    }

    @NonNull
    @Override
    public LeaderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_learning, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderAdapter.ViewHolder holder, int position) {


        if(itemListLeader.get(position).getBadgeUrl().isEmpty()){
            holder.mImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.toplearner));
        }else{

            Picasso.with(context)
                    .load(itemListLeader.get(position).getBadgeUrl())
                    .error(R.drawable.toplearner)
                    .fit()
                    .centerCrop()
                    .into(holder.mImageView);

        }

        holder.mTextView1.setText(itemListLeader.get(position).getName());
        holder.mTextView2.setText(String.format("%d", itemListLeader.get(position).getHours()));
        holder.mTextView3.setText(itemListLeader.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return itemListLeader.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView1, mTextView2, mTextView3 ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView =  itemView.findViewById(R.id.item_img_learning);
            mTextView1 = itemView.findViewById(R.id.leader_name);
            mTextView2 = itemView.findViewById(R.id.leader_result);
            mTextView3 = itemView.findViewById(R.id.country);



        }
    }
}

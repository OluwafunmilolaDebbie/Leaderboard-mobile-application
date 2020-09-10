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

import static java.lang.String.format;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    List<SkillModelResponse> itemListSkill;
    private Context context;

    public SkillAdapter(Context context, List<SkillModelResponse> itemList) {
        this.itemListSkill = itemList;
       this. context = context;
    }

    @NonNull
    @Override
    public SkillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_skill, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.ViewHolder holder, int position) {

//
        if (itemListSkill.get(position).getBadgeUrl().isEmpty()){
            holder.mImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.skilliqtrimmed));
        }else {
            Picasso.with(context)
                    .load(itemListSkill.get(position).getBadgeUrl())
                    .error(R.drawable.skilliqtrimmed)
                    .fit()
                    .centerCrop()
                    .into(holder.mImageView);
        }


    holder.mTextView1.setText(itemListSkill.get(position).getName());
    holder.mTextView2.setText(format("%d", itemListSkill.get(position).getScore()));
    holder.mTextView3.setText(itemListSkill.get(position).getCountry());

    }

    @Override
    public int getItemCount() {
        return itemListSkill.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView1, mTextView2, mTextView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_img_skill);
            mTextView1 = itemView.findViewById(R.id.skiller_name);
            mTextView2 = itemView.findViewById(R.id.skiller_result);
            mTextView3 = itemView.findViewById(R.id.country);
        }
    }
}

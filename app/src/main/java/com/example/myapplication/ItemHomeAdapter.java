package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemHomeAdapter extends RecyclerView.Adapter<ItemHomeAdapter.ItemHomeViewHolder> {

    private List<ItemHomeInfo> itemHomeInfoList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mListener = listener;
    }

    public ItemHomeAdapter(List<ItemHomeInfo> itemList){
        this.itemHomeInfoList = itemList;
    }
    @NonNull
    @Override
    public ItemHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false);
        return new ItemHomeViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHomeViewHolder holder, int position) {
        ItemHomeInfo item = itemHomeInfoList.get(position);
        holder.vTitle.setText(item.title);
        holder.vImageMain.setImageResource(item.image);
        holder.vShortDes.setText(item.shortDes);
    }

    @Override
    public int getItemCount() {
        return itemHomeInfoList.size();
    }

    public static class ItemHomeViewHolder extends RecyclerView.ViewHolder{
        protected TextView vTitle;
        protected ImageView vImageMain;
        protected TextView vShortDes;

        public ItemHomeViewHolder(View itemView, final OnItemClickListener listener){
            super(itemView);
            vTitle = (TextView) itemView.findViewById(R.id.title);
            vImageMain =(ImageView) itemView.findViewById(R.id.imageMain);
            vShortDes = (TextView) itemView.findViewById(R.id.textShortDes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

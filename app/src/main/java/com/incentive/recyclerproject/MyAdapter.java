package com.incentive.recyclerproject;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int count = 0;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 13:
            case 16:
            case 19:
                return R.layout.item_recyclable;
        }
        return R.layout.item_normal;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        RecyclerView.ViewHolder holder = viewType == R.layout.item_recyclable
                ? new RecyclableViewHolder(view) : new NormalViewHolder(view);

        if (holder instanceof RecyclableViewHolder) {
            count++;
            Log.i("vvv", "created " + count + " holder");
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onViewAttachedToWindow(final RecyclerView.ViewHolder holder) {
        if (holder instanceof RecyclableViewHolder) {
            holder.setIsRecyclable(false);
        }
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(final RecyclerView.ViewHolder holder) {
        if (holder instanceof RecyclableViewHolder) {
            holder.setIsRecyclable(true);
        }
        super.onViewDetachedFromWindow(holder);
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        public NormalViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class RecyclableViewHolder extends RecyclerView.ViewHolder {
        public RecyclableViewHolder(View itemView) {
            super(itemView);
        }
    }
}

package com.pucmm.parcial1temasespeciales;

import androidx.recyclerview.widget.RecyclerView;

import android.service.autofill.FillEventHistory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pucmm.parcial1temasespeciales.databinding.FragmentItemBinding;
import com.pucmm.parcial1temasespeciales.placeholder.PlaceholderContent.PlaceholderVersion;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderVersion}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderVersion> mValues;
    private final onTouchList<PlaceholderVersion> mListener;

    public MyItemRecyclerViewAdapter(List<PlaceholderVersion> items, onTouchList<PlaceholderVersion> listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        FragmentItemBinding binding = FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding, mListener);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName());
        //holder.mContentView.setText(mValues.get(position).);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderVersion mItem;
        private onTouchList<PlaceholderVersion> mListener;

        public ViewHolder(FragmentItemBinding binding, onTouchList<PlaceholderVersion> listener) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            mListener = listener;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(mItem);
        }
    }
}
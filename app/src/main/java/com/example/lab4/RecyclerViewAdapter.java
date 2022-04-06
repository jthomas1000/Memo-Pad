package com.example.lab4;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.lab4.databinding.MemoItemBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private MemoItemBinding binding;
    private List<Memo> data;

    public RecyclerViewAdapter(List<Memo> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder holder = new ViewHolder(binding.getRoot());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setMemo(data.get(position));
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Memo memo;
        private Memo id;
        private TextView memoLabel;
        private TextView memoNumlabel;


        public ViewHolder(View itemView) {
            super(itemView);
        }

        public Memo getMemo() {
            return memo;
        }

        public void setMemo(Memo memo) {
            this.memo = memo;
        }

        public Memo getId() {
            return id;
        }

        public void setId(Memo id) {
            this.id = id;
        }

        public void bindData() {

            if (memoLabel == null) {
                memoLabel = (TextView) itemView.findViewById(R.id.memoLabel);
            }
            if (memoNumlabel == null) {
                memoNumlabel = (TextView) itemView.findViewById(R.id.memoNumlabel);
            }
            memoLabel.setText(memo.getMemo());
            memoNumlabel.setText(id.getId());

        }

    }

}
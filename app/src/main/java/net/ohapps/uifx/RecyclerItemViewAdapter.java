package net.ohapps.uifx;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * fantasiacjh@gmail.com
 */
public class RecyclerItemViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<RecyclerItemView> items = new ArrayList<>();

    public ArrayList<RecyclerItemView> getItems() {
        return items;
    }

    public void setItems(ArrayList<RecyclerItemView> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getItemViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RecyclerItemViewHolderFactory.getInstance().create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        this.items.get(position).onBindViewHolder(holder);
    }
}

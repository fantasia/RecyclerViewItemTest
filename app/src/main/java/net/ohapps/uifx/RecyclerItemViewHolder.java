package net.ohapps.uifx;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * fantasiacjh@gmail.com
 */
public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    View itemView;

    public RecyclerItemViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public View getItemView() {
        return itemView;
    }
}



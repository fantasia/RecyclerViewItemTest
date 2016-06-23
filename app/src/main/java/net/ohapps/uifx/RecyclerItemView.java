package net.ohapps.uifx;

import android.support.v7.widget.RecyclerView;

/**
 * fantasiacjh@gmail.com
 */
public interface RecyclerItemView<T extends RecyclerView.ViewHolder> {
    /**
     * must return to inflate view
     *
     * @return R.layout.viewtype
     */
    int getItemViewType();

    void onBindViewHolder(T viewHolder);

}

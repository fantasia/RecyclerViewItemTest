package net.ohapps.uifx;

/**
 * fantasiacjh@gmail.com
 */
public interface RecyclerItemView<T extends RecyclerItemViewHolder> {
    /**
     * must return to inflate view
     *
     * @return R.layout.viewtype
     */
    int getItemViewType();

    void onBindViewHolder(T viewHolder);

}

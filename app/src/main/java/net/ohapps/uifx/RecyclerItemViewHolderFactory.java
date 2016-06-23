package net.ohapps.uifx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fantasiacjh@gmail.com
 */
public class RecyclerItemViewHolderFactory {
    public static RecyclerItemViewHolder create(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerItemViewHolder(v);
    }
}

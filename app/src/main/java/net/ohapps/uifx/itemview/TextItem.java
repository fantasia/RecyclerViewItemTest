package net.ohapps.uifx.itemview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import net.ohapps.recyclerviewitemtest.R;
import net.ohapps.uifx.RecyclerItemView;

/**
 * fantasiacjh@gmail.com
 */
public class TextItem implements RecyclerItemView {
    String t1;
    String t2;
    String t3;

    public TextItem(String t1, String t2, String t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public int getItemViewType() {
        return R.layout.rv_text_item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        View v = viewHolder.itemView;
        ((TextView) v.findViewById(R.id.tv01)).setText(t1);
        ((TextView) v.findViewById(R.id.tv02)).setText(t2);
        ((TextView) v.findViewById(R.id.tv03)).setText(t3);
    }

    @Override
    public String toString() {
        return "TextItem " + t1;
    }
}

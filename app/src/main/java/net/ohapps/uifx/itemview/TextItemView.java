package net.ohapps.uifx.itemview;

import android.view.View;
import android.widget.TextView;

import net.ohapps.recyclerviewitemtest.R;
import net.ohapps.uifx.RecyclerItemView;
import net.ohapps.uifx.RecyclerItemViewHolder;

/**
 * fantasiacjh@gmail.com
 */
public class TextItemView implements RecyclerItemView {
    String t1;
    String t2;
    String t3;

    public TextItemView(String t1, String t2, String t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public int getItemViewType() {
        return R.layout.rv_text_item;
    }

    @Override
    public void onBindViewHolder(RecyclerItemViewHolder viewHolder) {
        View v = viewHolder.getItemView();
        ((TextView) v.findViewById(R.id.tv01)).setText(t1);
        ((TextView) v.findViewById(R.id.tv02)).setText(t2);
        ((TextView) v.findViewById(R.id.tv03)).setText(t3);
    }

    @Override
    public String toString() {
        return "TextItemView " + t1;
    }
}

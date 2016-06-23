package net.ohapps.uifx.itemview;

import net.ohapps.recyclerviewitemtest.R;
import net.ohapps.uifx.RecyclerItemView;

/**
 * fantasiacjh@gmail.com
 */
public class ImageItem implements RecyclerItemView<ImageItemViewHolder> {
    String t1;
    String t2;
    String t3;

    public ImageItem(String t1, String t2, String t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public int getItemViewType() {
        return R.layout.rv_image_item;
    }

    @Override
    public void onBindViewHolder(ImageItemViewHolder viewHolder) {
        viewHolder.setTexts(t1, t2, t3);
    }

    @Override
    public String toString() {
        return "ImageItem " + t1;
    }
}

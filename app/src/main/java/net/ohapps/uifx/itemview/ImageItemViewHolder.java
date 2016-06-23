package net.ohapps.uifx.itemview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.ohapps.recyclerviewitemtest.R;
import net.ohapps.uifx.RecyclerItemViewHolder;

/**
 * fantasiacjh@gmail.com
 */
public class ImageItemViewHolder extends RecyclerItemViewHolder {
    private ImageView iv01;
    private TextView tv01;
    private TextView tv02;
    private TextView tv03;

    public ImageItemViewHolder(View v) {
        super(v);
        this.iv01 = (ImageView) v.findViewById(R.id.iv01);
        this.tv01 = (TextView) v.findViewById(R.id.tv01);
        this.tv02 = (TextView) v.findViewById(R.id.tv02);
        this.tv03 = (TextView) v.findViewById(R.id.tv03);
    }

    public ImageView getIv01() {
        return iv01;
    }

    public void setTexts(String t1, String t2, String t3) {
        tv01.setText(t1);
        tv02.setText(t2);
        tv03.setText(t3);
    }
}

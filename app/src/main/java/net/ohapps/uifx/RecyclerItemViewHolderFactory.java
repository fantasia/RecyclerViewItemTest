package net.ohapps.uifx;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ohapps.recyclerviewitemtest.R;
import net.ohapps.uifx.itemview.ImageItemViewHolder;

import java.util.HashMap;

/**
 * fantasiacjh@gmail.com
 */
public class RecyclerItemViewHolderFactory {
    public interface RecyclerItemViewHolderCreator {
        RecyclerView.ViewHolder create(View v);
    }

    private static RecyclerItemViewHolderFactory instance = new RecyclerItemViewHolderFactory();

    private RecyclerItemViewHolderFactory() {
        registerViewType(R.layout.rv_image_item, new RecyclerItemViewHolderCreator() {
            @Override
            public RecyclerView.ViewHolder create(View v) {
                return new ImageItemViewHolder(v);
            }
        });
    }

    public static RecyclerItemViewHolderFactory getInstance() {
        return instance;
    }

    private HashMap<Integer, RecyclerItemViewHolderCreator> creatorMap = new HashMap<>();

    public void registerViewType(int viewType, RecyclerItemViewHolderCreator creator) {
        creatorMap.put(viewType, creator);
    }

    public RecyclerView.ViewHolder create(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        RecyclerItemViewHolderCreator creator = creatorMap.get(viewType);
        if (null != creator) {
            return creator.create(v);
        } else {
            return new RecyclerView.ViewHolder(v) {
            };
        }
    }
}

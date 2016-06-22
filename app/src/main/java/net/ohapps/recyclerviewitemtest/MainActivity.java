package net.ohapps.recyclerviewitemtest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    interface RecyclerViewItem {
        int getResourceId();

        void onBindViewHolder(RecyclerItemViewHolder viewHolder);
    }

    static class ImageViewItem implements RecyclerViewItem {
        String t1;
        String t2;
        String t3;

        public ImageViewItem(String t1, String t2, String t3) {
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
        }

        @Override
        public int getResourceId() {
            return R.layout.rv_image_item;
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
            return "ImageViewItem " + t1;
        }
    }

    static class TextViewItem implements RecyclerViewItem {
        String t1;
        String t2;
        String t3;

        public TextViewItem(String t1, String t2, String t3) {
            this.t1 = t1;
            this.t2 = t2;
            this.t3 = t3;
        }

        @Override
        public int getResourceId() {
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
            return "TextViewItem " + t1;
        }
    }

    static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        View itemView;

        public RecyclerItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public View getItemView() {
            return itemView;
        }
    }

    static class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerItemViewHolder> {
        ArrayList<RecyclerViewItem> items = new ArrayList<>();

        public ArrayList<RecyclerViewItem> getItems() {
            return items;
        }

        public void setItems(ArrayList<RecyclerViewItem> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
            return new RecyclerItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerItemViewHolder holder, int position) {
            this.items.get(position).onBindViewHolder(holder);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getResourceId();
        }
    }

    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildPosition(childView));
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerViewItemAdapter recyclerViewItemAdapter = new RecyclerViewItemAdapter();
        recyclerView.setAdapter(recyclerViewItemAdapter);

        recyclerViewItemAdapter.setItems(uiDataManagerGetItems());

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("XXX", "onItemClick() " + recyclerViewItemAdapter.getItems().get(position));
            }
        }));
    }

    @NonNull
    private ArrayList<RecyclerViewItem> uiDataManagerGetItems() {
        ArrayList<RecyclerViewItem> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                items.add(new TextViewItem("Title " + i, "Content " + i, "Date " + i));
            } else {
                items.add(new ImageViewItem("Image " + i, "Desc " + i, "Size " + i));
            }
        }
        return items;
    }
}

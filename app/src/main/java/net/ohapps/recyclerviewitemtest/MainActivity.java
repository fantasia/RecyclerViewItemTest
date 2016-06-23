package net.ohapps.recyclerviewitemtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import net.ohapps.uifx.RecyclerItemClickListener;
import net.ohapps.uifx.RecyclerItemView;
import net.ohapps.uifx.RecyclerItemViewAdapter;
import net.ohapps.uifx.itemview.ImageItem;
import net.ohapps.uifx.itemview.TextItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, View itemView, int position) {
                String msg = "onItemClick() " + ((RecyclerItemViewAdapter) recyclerView.getAdapter()).getItems().get(position);
                Log.i("XXX", msg);
                Toast.makeText(recyclerView.getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerItemViewAdapter recyclerItemViewAdapter = new RecyclerItemViewAdapter();
        recyclerView.setAdapter(recyclerItemViewAdapter);

        recyclerItemViewAdapter.setItems(uiDataManagerGetItems());

    }

    @NonNull
    private ArrayList<RecyclerItemView> uiDataManagerGetItems() {
        ArrayList<RecyclerItemView> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                items.add(new TextItem("Title " + i, "Content " + i, "Date " + i));
            } else {
                items.add(new ImageItem("Image " + i, "Desc " + i, "Size " + i));
            }
        }
        return items;
    }
}

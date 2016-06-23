package net.ohapps.recyclerviewitemtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import net.ohapps.uifx.RecyclerItemClickListener;
import net.ohapps.uifx.RecyclerItemView;
import net.ohapps.uifx.RecyclerItemViewAdapter;
import net.ohapps.uifx.itemview.ImageItemView;
import net.ohapps.uifx.itemview.TextItemView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerItemViewAdapter recyclerItemViewAdapter = new RecyclerItemViewAdapter();
        recyclerView.setAdapter(recyclerItemViewAdapter);

        recyclerItemViewAdapter.setItems(uiDataManagerGetItems());

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "onItemClick() " + recyclerItemViewAdapter.getItems().get(position), Toast.LENGTH_SHORT).show();
//                Log.d("XXX", "onItemClick() " + recyclerItemViewAdapter.getItems().get(position));
            }
        }));
    }

    @NonNull
    private ArrayList<RecyclerItemView> uiDataManagerGetItems() {
        ArrayList<RecyclerItemView> items = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                items.add(new TextItemView("Title " + i, "Content " + i, "Date " + i));
            } else {
                items.add(new ImageItemView("Image " + i, "Desc " + i, "Size " + i));
            }
        }
        return items;
    }
}

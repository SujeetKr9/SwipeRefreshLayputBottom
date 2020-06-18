package com.sujeet.swiperefreshlayoutbottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayoutBottom swipeRefreshLayout;
    private int remainingValidityDays = 0;

    List<UserModel> modelList = new ArrayList<>();
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);


        for (int i = 0; i< 20; i++){
            UserModel model = new UserModel(
                    "Sujeet"+i,"7989643"
            );
            modelList.add(model);
        }

        userAdapter = new UserAdapter(modelList, MainActivity.this);

        recyclerView.setAdapter(userAdapter);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutBottom.OnRefreshListener() {
            @Override
            public void onRefresh() {

                loadProfiles();

            }
        });

       // loadProfiles();
    }

    private void loadProfiles() {
        Log.e("LOAD", "loadProfiles");
       // if (modelList.size() < 20) {
       //     swipeRefreshLayout.setEnabled(false);
      //  }

        int size = this.modelList.size();
        this.modelList.addAll(modelList);
        userAdapter.notifyItemRangeInserted(size, modelList.size());
        recyclerView.smoothScrollToPosition(size);

        swipeRefreshLayout.setRefreshing(false);
    }
}

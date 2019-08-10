package com.naufalprakoso.posttrainingandroidpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.naufalprakoso.posttrainingandroidpart2.adapter.RecyclerViewAdapter;
import com.naufalprakoso.posttrainingandroidpart2.model.User;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataDesc;
    private RecyclerViewAdapter adapter;

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        adapter = new RecyclerViewAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.rv_user);

        prepare();
        initData();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void prepare(){
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDesc = getResources().getStringArray(R.array.data_desc);
    }

    private void initData(){
        users = new ArrayList<>();

        for (int i=0;i<dataTitle.length;i++){
            User user = new User();
            user.setName(dataTitle[i]);
            user.setDesc(dataDesc[i]);

            users.add(user);
        }

        adapter.setUsers(users);
    }
}

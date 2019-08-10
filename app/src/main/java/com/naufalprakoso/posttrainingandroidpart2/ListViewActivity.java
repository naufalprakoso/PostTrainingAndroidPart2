package com.naufalprakoso.posttrainingandroidpart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.naufalprakoso.posttrainingandroidpart2.adapter.ListViewAdapter;
import com.naufalprakoso.posttrainingandroidpart2.model.User;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataDesc;
    private ListViewAdapter adapter;

    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        adapter = new ListViewAdapter(this);
        ListView listView = findViewById(R.id.lv_user);

        prepare();
        initData();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, users.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDesc = getResources().getStringArray(R.array.data_desc);
    }

    private void initData() {
        users = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            User user = new User();
            user.setName(dataTitle[i]);
            user.setDesc(dataDesc[i]);

            users.add(user);
        }

        adapter.setUsers(users);
    }
}

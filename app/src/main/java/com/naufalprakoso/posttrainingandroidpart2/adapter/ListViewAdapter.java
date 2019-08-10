package com.naufalprakoso.posttrainingandroidpart2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.naufalprakoso.posttrainingandroidpart2.R;
import com.naufalprakoso.posttrainingandroidpart2.model.User;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ListViewAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_list_view, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        User user = (User) getItem(i);
        viewHolder.bindItem(user);

        return view;
    }

    private class ViewHolder{
        TextView txtTitle, txtDesc;

        ViewHolder(View view){
            txtTitle = view.findViewById(R.id.txt_title);
            txtDesc = view.findViewById(R.id.txt_desc);
        }

        void bindItem(User user){
            txtTitle.setText(user.getName());
            txtDesc.setText(user.getDesc());
        }
    }
}

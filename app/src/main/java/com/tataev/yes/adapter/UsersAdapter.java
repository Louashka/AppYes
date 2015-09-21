package com.tataev.yes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tataev.yes.R;
import com.tataev.yes.RoundImage;
import com.tataev.yes.UsersList;

import java.util.ArrayList;

/**
 * Created by lou on 17.09.2015.
 */
public class UsersAdapter extends BaseAdapter {

    private ArrayList<UsersList> usersList;
    private Context context;
    private LayoutInflater l_InflaterUA;

    public UsersAdapter (Context context, ArrayList<UsersList> usersList) {
        this.context = context;
        this.usersList = usersList;
        l_InflaterUA = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        return usersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        RoundImage roundedImage = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = l_InflaterUA.inflate(R.layout.users_adapter, null);
            holder.imageUsersAva = (ImageView)convertView.findViewById(R.id.imageUsersAva);
            holder.usersName = (TextView)convertView.findViewById(R.id.usersName);
            holder.usersStatus = (RadioButton)convertView.findViewById(R.id.usersStatus);
            roundedImage = new RoundImage(usersList.get(position).getUserBitmap());
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (roundedImage != null){
            holder.imageUsersAva.setImageDrawable(roundedImage);
        }
        holder.usersName.setText(usersList.get(position).getUserName());
        holder.usersStatus.setChecked(usersList.get(position).getUserStatus());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageUsersAva;
        TextView usersName;
        RadioButton usersStatus;
    }
}

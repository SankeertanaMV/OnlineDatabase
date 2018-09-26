package com.example.sankeerthana.onlinedatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public UserAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(User object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row;
        row = convertView;
        UserHolder userHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            userHolder = new UserHolder();
            userHolder.year = (TextView) row.findViewById(R.id.year);
            userHolder.month = (TextView) row.findViewById(R.id.month);
            userHolder.name = (TextView) row.findViewById(R.id.name);
            userHolder.mailId = (TextView) row.findViewById(R.id.mailId);
            userHolder.bill_ep1 = (TextView) row.findViewById(R.id.bill_ep1);
            userHolder.bill_ep2 = (TextView) row.findViewById(R.id.bill_ep2);
            userHolder.bill_ep3 = (TextView) row.findViewById(R.id.bill_ep3);
            userHolder.bill_flat = (TextView) row.findViewById(R.id.bill_flat);
            userHolder.usage_ep1 = (TextView) row.findViewById(R.id.usage_ep1);
            userHolder.usage_ep2 = (TextView) row.findViewById(R.id.usage_ep2);
            userHolder.usage_ep3 = (TextView) row.findViewById(R.id.usage_ep3);
            userHolder.usage_flat = (TextView) row.findViewById(R.id.usage_flat);
            row.setTag(userHolder);

        }
        else
        {
            userHolder = (UserHolder)row.getTag();
        }

        User user = (User) this.getItem(position);
        userHolder.year.setText(user.getYear());
        userHolder.month.setText(user.getMonth());
        userHolder.name.setText(user.getName());
        userHolder.mailId.setText(user.getMailId());
        userHolder.bill_ep1.setText(user.getBill_ep1());
        userHolder.bill_ep2.setText(user.getBill_ep2());
        userHolder.bill_ep3.setText(user.getBill_ep3());
        userHolder.bill_flat.setText(user.getBill_flat());
        userHolder.usage_ep1.setText(user.getUsage_ep1());
        userHolder.usage_ep2.setText(user.getUsage_ep2());
        userHolder.usage_ep3.setText(user.getUsage_ep3());
        userHolder.usage_flat.setText(user.getUsage_flat());
        return row;
    }

    static class UserHolder{
        TextView year,month,name,mailId,bill_ep1,bill_ep2,bill_ep3,bill_flat,usage_ep1,usage_ep2,usage_ep3,usage_flat;

    }

}

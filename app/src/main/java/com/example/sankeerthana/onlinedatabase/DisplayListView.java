package com.example.sankeerthana.onlinedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    UserAdapter userAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);
        listView = (ListView) findViewById(R.id.listview);
        userAdapter = new UserAdapter(this, R.layout.row_layout);
        listView.setAdapter(userAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;

            String year,month,name,mailId,bill_ep1,bill_ep2,bill_ep3,bill_flat,usage_ep1,usage_ep2,usage_ep3,usage_flat;

            while (count < jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);
                year = JO.getString("year");
                month = JO.getString("month");
                name = JO.getString("name");
                mailId = JO.getString("mailId");
                bill_ep1 = JO.getString("bill_ep1");
                bill_ep2 = JO.getString("bill_ep2");
                bill_ep3 = JO.getString("bill_ep3");
                bill_flat = JO.getString("bill_flat");
                usage_ep1 = JO.getString("usage_ep1");
                usage_ep2 = JO.getString("usage_ep2");
                usage_ep3 = JO.getString("usage_ep3");
                usage_flat = JO.getString("usage_flat");

                User user = new User(year,month,name,mailId,bill_ep1,bill_ep2,bill_ep3,bill_flat,usage_ep1,usage_ep2,usage_ep3,usage_flat);
                userAdapter.add(user);

                count++;


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

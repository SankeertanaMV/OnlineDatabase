package com.example.sankeerthana.onlinedatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {
    Button button1,button2;
    TextView textview;
    String json_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        textview = (TextView)findViewById(R.id.textview);
    }

    public void getJSON(View view) {

        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void,Void,String>{


        String json_url;
        String JSON_STRING;

        @Override
        protected void onPreExecute() {
           json_url = "https://aquameter.000webhostapp.com/json_get_data.php";
        }


        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((JSON_STRING = bufferedReader.readLine())!= null)
                {
                    stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }


        @Override
        protected void onPostExecute(String result) {

            textview.setText(result);
            json_string = result;
        }
    }

    public void parseJSON(View view) {
        if(json_string==null){
            Toast.makeText(getApplicationContext(),"First get Json",Toast.LENGTH_LONG).show();
        }

        else{
            Intent intent = new Intent(Main2Activity.this, DisplayListView.class);
            intent.putExtra("json_data", json_string);
            startActivity(intent);
        }


    }
}

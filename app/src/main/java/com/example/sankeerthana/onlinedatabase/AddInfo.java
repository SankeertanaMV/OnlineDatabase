package com.example.sankeerthana.onlinedatabase;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AddInfo extends AppCompatActivity {
    EditText Name,Email,Password,Flatno,Address;
    Button Register;
    String name,email,password,flatno,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        Name = (EditText)findViewById(R.id.et_name);
        Email = (EditText)findViewById(R.id.et_email);
        Password = (EditText)findViewById(R.id.et_password);
        Flatno = (EditText)findViewById(R.id.et_flatno);
        Address = (EditText)findViewById(R.id.et_address);

        Register = (Button)findViewById(R.id.et_register);


    }

    public void register(View view) {

        name = Name.getText().toString();
        email = Email.getText().toString();
        password = Password.getText().toString();
        flatno = Flatno.getText().toString();
        address = Address.getText().toString();

        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute(name,email,password,flatno,address);
        finish();
    }

    class BackgroundTask extends AsyncTask<String,Void,String> {


        String addUser_url;
        @Override
        protected void onPreExecute() {
            addUser_url = "https://aquameter.000webhostapp.com/add_info.php";
        }

        @Override
        protected String doInBackground(String... args) {
            String name,email,password,flatno,address;
            name = args[0];
            email = args[1];
            password = args[2];
            flatno = args[3];
            address = args[4];

            try {
                URL url = new URL(addUser_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data_string = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("flatno","UTF-8")+"="+URLEncoder.encode(flatno,"UTF-8")+"&"+
                        URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "One row of Data inserted..";




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
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }


    }

}

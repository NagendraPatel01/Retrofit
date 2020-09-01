 package com.example.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class MainActivity extends AppCompatActivity {

     TextView title,title1,title2,title3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        title3 = findViewById(R.id.title3);

        RetrofitClint.getRetrofit()
                .create(GetRequest.class)
                .getData()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                        Log.d("dzhjdfdsbh", "onResponse: "+response);
                        Log.d("dsbjhdfsd", "onResponse: "+response.body());
                        Log.d("dshbdsbhjds", "onResponse: "+response.body().get("title"));
                        Log.d("dshbdsbhjds", "onResponse: "+response.body().get("userId"));
                        Log.d("dshbdsbhjds", "onResponse: "+response.body().get("id"));
                        Log.d("dshbdsbhjds", "onResponse: "+response.body().get("completed"));

                        title.setText(response.body().get("title").toString());
                        title1.setText(response.body().get("userId").toString());
                        title2.setText(response.body().get("id").toString());
                        title3.setText(response.body().get("completed").toString());
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                        Log.d("dsjhdsds", "onFailure: "+t.getMessage());
                    }
                });
    }
}
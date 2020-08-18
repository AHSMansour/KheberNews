package com.abomansour.khabernews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.abomansour.khabernews.Adapter.Adapter;
import com.abomansour.khabernews.Utils.Utils;
import com.abomansour.khabernews.api.ApiClint;
import com.abomansour.khabernews.api.ApiInterface;
import com.abomansour.khabernews.modules.Artcail;
import com.abomansour.khabernews.modules.news;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final  String API_KEY ="c15209105d1f468085cfc3dfde2af303";
   // private static final String Country="eg";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Artcail> Artcail = new ArrayList<>();
    private Adapter adapter;
    private  String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recyclvew);
        layoutManager =new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        LoadJson();

    }

    public void LoadJson(){

        ApiInterface apiInterface = ApiClint.getRetrofit().create(ApiInterface.class);
        String country = Utils.getCountry();

        Call<news> call;
        call = apiInterface.getNews(country, API_KEY);

        call.enqueue(new Callback<news>() {
            @Override
            public void onResponse(Call<news> call, Response<news> response) {

                if (response.isSuccessful() && response.body().getArticles() != null){
                    if (!Artcail.isEmpty()) {
                        Artcail.clear();
                    }


                Artcail = response.body().getArticles();
                adapter = new Adapter(Artcail, MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();



            } else {
                Toast.makeText(MainActivity.this, "No Resulti", Toast.LENGTH_LONG).show();
            }
        }


            @Override
            public void onFailure(Call<news> call, Throwable t) {

            }
        });



    }
}

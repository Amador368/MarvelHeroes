package me.asantiago.marvelheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import me.asantiago.marvelheroes.Api.MarvelService;
import me.asantiago.marvelheroes.models.Basic;
import me.asantiago.marvelheroes.models.Data;
import me.asantiago.marvelheroes.models.SuperHero;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<Basic<Data<ArrayList<SuperHero>>>> superHeroesCall = MarvelService.getMarvelApi().getHeroes(354);
        superHeroesCall.enqueue(new Callback<Basic<Data<ArrayList<SuperHero>>>>() {
            @Override
            public void onResponse(Call<Basic<Data<ArrayList<SuperHero>>>> call, Response<Basic<Data<ArrayList<SuperHero>>>> response) {
                Toast.makeText(MainActivity.this, "Hero name:" + response.body().getData().getResults().get(0).getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Basic<Data<ArrayList<SuperHero>>>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

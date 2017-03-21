package me.asantiago.marvelheroes.Api;

import java.util.ArrayList;

import me.asantiago.marvelheroes.models.Basic;
import me.asantiago.marvelheroes.models.Data;
import me.asantiago.marvelheroes.models.SuperHero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by asantiago on 3/18/17.
 */

public interface Marvel {
    String BASE_URL = "http://gateway.marvel.com/";
    @GET("v1/public/series/{seriesId}/characters?apikey=6da6b71b5a6c4517d44ec2b5abe45ac7&ts=1&hash=d80c0ad13901c4e7f7dea889a1ac5919")
    Call<Basic<Data<ArrayList<SuperHero>>>> getHeroes(@Path("seriesId") int seriesId);//interface
}

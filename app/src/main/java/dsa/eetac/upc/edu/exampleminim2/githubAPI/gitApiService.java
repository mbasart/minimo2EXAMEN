package dsa.eetac.upc.edu.exampleminim2.githubAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dsa.eetac.upc.edu.exampleminim2.models.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface gitApiService {

    @GET("pag-ini/{ini}/pag-fi/{fi}")
    Call<Cities> obtenerCities(@Path("ini") int ini, @Path("fi") int fi);

    static gitApiService createAPIRest() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        String BASE_URL = "https://do.diba.cat/api/dataset/municipis/format/json/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(gitApiService.class);
    }

}

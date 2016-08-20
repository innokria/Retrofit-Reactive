package in.com.rebtel.rest;


import java.util.List;

import in.com.rebtel.model.Country;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiInterface {

    @GET("v1/all")
    Call<List<Country>> getName();

    //RX-WAY
    //TODO try reactive observable and observer pattern



   }

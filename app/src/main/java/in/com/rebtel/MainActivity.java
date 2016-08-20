package in.com.rebtel;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import in.com.rebtel.RebtelHelper.ExceptionHandler;
import in.com.rebtel.RebtelHelper.NetworkReceiver;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import in.com.rebtel.adapter.CountrysAdapter;
import in.com.rebtel.RebtelHelper.Helper;
import in.com.rebtel.rest.ApiInterface;
import in.com.rebtel.rest.ApiClient;
import in.com.rebtel.model.Country;
import android.widget.Toast;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;
import retrofit2.Call;

//COMMENTS -
// This is the first time i am trying Retrofit along with reactive programming
// (i still didn't user Observable pattern but i will try later), also i tried recycle view very 1st time
// Its fun and  i am still exploring the best out of it .
// Look for  TODO section to check my pending tasks to get my ideas
//
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo create class that extends Application and handle exception in that class
        //************GLOBAL EXCEPTION WAY HANDLING****************************
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        //*********************************************************************

         //TODO: make broadcast listener that will tell you network status but i am not doing it now, also can use service to check server data after some interval
        setContentView(R.layout.activity_main);

         /*
        //******* i am not using broadcast receiver as  retrofit automatically retries on failures**********************
        //********************** uncomment to activate  broadcast calls**********************
        NetworkReceiver receiver = new NetworkReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String someValue = intent.getStringExtra("android.net.conn.CONNECTIVITY_CHANGE");
                Toast.makeText(context, " server_is internet >>>" + someValue, Toast.LENGTH_SHORT).show();
                //do logic here

            }
        };

        LocalBroadcastManager.getInstance(this).registerReceiver(
                receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        */



     if( Helper.isNetworkAvailable(MainActivity.this) ) {

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<List<Country>> call = apiService.getName();
        //TODO show preloader while rendering data also can use reactive programming to handle  streaming of data instead of callback
        call.enqueue(new Callback<List<Country>>() {

            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
              if (response.isSuccessful()) {//response.code() == 200)  should also work
                    // Do logics
                    if(response.body().size()>0) {
                        List<Country> countries = response.body();
                         recyclerView.setAdapter(new CountrysAdapter(countries, R.layout.list_item_country, getApplicationContext()));
                        }

                } else if (response.code() == 401) {
                    // Handle unauthorized
                } else {
                    // Handle other responses
                }
             }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
             // Handle response
            }
        });
        }else{
            Toast.makeText(getApplicationContext(), "Please Turn On Your Internet" , Toast.LENGTH_LONG).show();
        }


    }

}

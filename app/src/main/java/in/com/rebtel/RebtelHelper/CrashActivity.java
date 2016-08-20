package in.com.rebtel.RebtelHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import in.com.rebtel.MainActivity;
import in.com.rebtel.R;


public class CrashActivity extends AppCompatActivity {
TextView txt;

    @Override
    public void onBackPressed() {


        Intent myIntent = new Intent(CrashActivity.this, MainActivity.class);
        startActivity(myIntent);
        finish();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Relax Page");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt=(TextView) findViewById(R.id.msg);


      Bundle bundle = getIntent().getExtras();
        if(bundle.getString("error")!= null)
        {
            txt.setText(bundle.getString("error"));

        }






    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:

                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

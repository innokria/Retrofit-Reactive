package in.com.rebtel;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.w3c.dom.Text;

import in.com.rebtel.RebtelHelper.ExceptionHandler;
import in.com.rebtel.model.Country;

public class DetailViewActivity extends AppCompatActivity {

    ImageView img;
    TextView title;



    public class CropSquareTransformation implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap result = Bitmap.createBitmap(source, x, y, size, size);


            // Bitmap result=  h.getRoundedCornerBitmap1( source,400);
            if (result != source) {
                source.recycle();
            }
            return result;
        }

        @Override
        public String key() {
            return "square()";
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        //************GLOBAL EXCEPTION WAY HANDLING****************************
         Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        //*********************************************************************

        //TODO now its toolbar , text should come from string.xml
        //// TODO: 8/20/2016  add init method also resize image to maintain aspect ratio, hard code constant value somehere

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title= (TextView) findViewById(R.id.title);
        img=(ImageView) findViewById(R.id.img) ;
        String im=getIntent().getStringExtra("link");

        String link="https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/"+im.toLowerCase()+".png";
                 Picasso.with(DetailViewActivity.this)
                        .load(link)
                        .transform(new CropSquareTransformation())
                        .into(img);
        title.setText(getIntent().getStringExtra("title"));
        System.out.println("link is "+link);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution

                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

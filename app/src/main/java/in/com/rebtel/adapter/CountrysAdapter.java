package in.com.rebtel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.com.rebtel.DetailViewActivity;
import in.com.rebtel.R;
import in.com.rebtel.model.Country;


public class CountrysAdapter extends RecyclerView.Adapter<CountrysAdapter.CountryViewHolder> {

    private List<Country> countries;
    private int rowLayout;
    private Context context;


    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView title;
        TextView data;

        ImageView img;


        public CountryViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.c_layout);
            title = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            img=(ImageView) v.findViewById(R.id.img);





        }




    }

    public CountrysAdapter(List<Country>countries, int rowLayout, Context context) {
        this.countries = countries;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CountryViewHolder(view);
    }



    @Override
    public void onBindViewHolder(final CountryViewHolder holder, final int position) {
        holder.title.setText(countries.get(position).getName());
        holder.data.setText(countries.get(position).getCapital());
        String link="https://raw.githubusercontent.com/hjnilsson/country-flags/master/png250px/"+countries.get(position).altSpellings.get(0)+".png";
        Picasso.with(context).load(link.toLowerCase()).into(holder.img);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //TODO send Object instead but since we need 2 info

                 Intent intent = new Intent(v.getContext(), DetailViewActivity.class);
                 intent.putExtra("title", countries.get(position).getName());
                 intent.putExtra("link", countries.get(position).altSpellings.get(0));
                 v.getContext().startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }


}
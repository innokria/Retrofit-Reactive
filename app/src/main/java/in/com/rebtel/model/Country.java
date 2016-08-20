package in.com.rebtel.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kumar0044q on 8/20/2016.
 */

public class Country {
    //use this to autogenerate model http://www.jsonschema2pojo.org/
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("capital")
    @Expose
    private String capital;


//    @SerializedName("altSpellings")
//    @Expose
//    private String altSpellings;

    @SerializedName("altSpellings")
    @Expose
    public List<String> altSpellings;
    private  String flag;







    public Country(String name, String capital,String flag)
    {
        this.name=name;
        this.capital=capital;
        this.flag=flag;
    }

//    public String getAltSpellings() {
//        return altSpellings;
//    }
//
//    public void setAltSpellings(String altSpellings) {
//        this.altSpellings = altSpellings;
//    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param title
     * The Name
     */
    public void setTitle(String title) {
        this.name = name;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString(){
        return(name);
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}





package in.com.rebtel.RebtelHelper;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by kumar0044q on 8/20/2016.
 */

public class Helper {

    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}

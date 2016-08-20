package in.com.rebtel.RebtelHelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kumar0044q on 8/20/2016.
 */

public class NetworkReceiver extends BroadcastReceiver {

    // this class is not in actual use but i just created to test
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE );
         boolean isConnected = connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        intent.putExtra("android.net.conn.CONNECTIVITY_CHANGE",""+ isConnected);




    }
}

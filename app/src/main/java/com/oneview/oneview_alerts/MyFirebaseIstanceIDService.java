package com.oneview.oneview_alerts;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseInsIDService";

    @Override
    public void onTokenRefresh() {
        // Get updated token

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token" + refreshedToken);

        //You can save the token into third party server to do anything you want
    }
}

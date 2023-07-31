package com.noti.plugin.message;

import android.content.Context;

import com.noti.plugin.Plugin;
import com.noti.plugin.data.PairDeviceInfo;
import com.noti.plugin.listener.PluginResponse;
import com.noti.plugin.process.PluginAction;

public class PluginResponses implements PluginResponse {
    @Override
    public void onReceiveRemoteActionRequest(Context context, PairDeviceInfo device, String type, String args) {

    }

    @Override
    public void onReceiveRemoteDataRequest(Context context, PairDeviceInfo device, String type) {

    }

    @Override
    public void onReceiveException(Context context, Exception e) {
        e.printStackTrace();
    }
}

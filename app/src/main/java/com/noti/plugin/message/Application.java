package com.noti.plugin.message;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.noti.plugin.Plugin;

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initPlugin(this);
    }

    public static void initPlugin(Context context) {
        Plugin plugin = Plugin.init(new PluginResponses());

        plugin.setPluginDescription("Plugin for Receive call & message information");
        plugin.setAppPackageName(context.getPackageName());
        plugin.setSettingClass(MainActivity.class);
        plugin.setPluginTitle("Instant Messaging");
        plugin.setRequireSensitiveAPI(false);

        checkPermission(context);
    }

    public static void checkPermission(Context context) {
        boolean isNotificationPermission = Build.VERSION.SDK_INT < 31 || ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).areNotificationsEnabled();
        Plugin.getInstance().setPluginReady(isNotificationPermission);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", MODE_PRIVATE);
    }
}

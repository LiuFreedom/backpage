package com.kelan.powerapp.utils;

import android.util.Log;

/**
 * Created by Ocean Liu on 2017/10/26/0026.
 */

public class LogUtil {
    public static void logE(String content) {
        int p = 2048;
        String tag = "<---------->";
        long length = content.length();
        if (length < p || length == p)
            Log.e(tag, content);
        else {
            while (content.length() > p) {
                String logContent = content.substring(0, p);
                content = content.replace(logContent, "");
                Log.e(tag, logContent);
            }
            Log.e(tag, content);
        }
    }
}

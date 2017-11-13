package com.kelan.powerapp.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ocean Liu on 2017/10/26/0026.
 */

public class StringToDate {

    /*
     *将 2017-11-13转为1000000000
     */
    public static String stringToLong2(String stringTime) {
        String formatType = "yyyy-MM-dd";
        Date date = stringToDate(stringTime, formatType); // String类型转成date类型
        if (date == null) {
            return "";
        } else {
            long currentTime = date.getTime(); // date类型转成long类型
            String LongtoString = String.valueOf(currentTime);
            return LongtoString;
        }
    }

    /**
     * 后台转化成时间
     *将1000000转为 2017-11-13 11:30
     */
    public static String stringToDate(String lo) {
        if (TextUtils.isEmpty(lo)) {
            return "暂无";
        }
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sd.format(date);
    }

    /**
     * 后台转化成时间
     *将1000000转为 2017-11-13
     */
    public static String stringToDate2(String lo) {
        if (TextUtils.isEmpty(lo)) {
            return "暂无";
        }
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(date);
    }
    /*
         *将 2017-11-13 11:30转为1000000000
         */
    public static String stringToLong(String stringTime) {
        String formatType = "yyyy-MM-dd HH:mm";
        Date date = stringToDate(stringTime, formatType); // String类型转成date类型
        if (date == null) {
            return "";
        } else {
            long currentTime = date.getTime(); // date类型转成long类型
            String LongtoString = String.valueOf(currentTime);
            return LongtoString;
        }
    }

    public static Date stringToDate(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @SuppressLint("SimpleDateFormat")
    public static String turnTodate(String lo) {
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(date);
    }
}

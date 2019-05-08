package com.donnie.grow.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static Date parse(String dateStr, String formatStr) {
        try {
            return new SimpleDateFormat(formatStr).parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String formatStr) {
        return new SimpleDateFormat(formatStr).format(date);
    }

    public static Date addMonths(Date date, int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hours);
        return c.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);
        return c.getTime();
    }
}

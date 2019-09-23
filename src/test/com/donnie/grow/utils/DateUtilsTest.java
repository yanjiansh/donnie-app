package com.donnie.grow.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateUtilsTest {

    @Test
    public void parseAndFormatTest() {
        Date d = DateUtils.parse("2019-05-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Assert.assertEquals(DateUtils.format(d, DateUtils.DEFAULT_FORMAT), "2019-05-08 11:22:33");
    }

    @Test
    public void addMonthsTest() {
        Date d1 = DateUtils.parse("2019-05-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d2 = DateUtils.parse("2019-07-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d3 = DateUtils.parse("2019-03-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Assert.assertEquals(DateUtils.addMonths(d1, 2), d2);
        Assert.assertEquals(DateUtils.addMonths(d1, -2), d3);
    }

    @Test
    public void addDaysTest() {
        Date d1 = DateUtils.parse("2019-05-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d2 = DateUtils.parse("2019-05-18 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d3 = DateUtils.parse("2019-04-28 11:22:33", DateUtils.DEFAULT_FORMAT);
        Assert.assertEquals(DateUtils.addDays(d1, 10), d2);
        Assert.assertEquals(DateUtils.addDays(d1, -10), d3);
    }

    @Test
    public void addHoursTest() {
        Date d1 = DateUtils.parse("2019-05-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d2 = DateUtils.parse("2019-05-09 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d3 = DateUtils.parse("2019-05-07 11:22:33", DateUtils.DEFAULT_FORMAT);
        Assert.assertEquals(DateUtils.addHours(d1, 24), d2);
        Assert.assertEquals(DateUtils.addHours(d1, -24), d3);
    }

    @Test
    public void addMinutesTest() {
        Date d1 = DateUtils.parse("2019-05-08 11:22:33", DateUtils.DEFAULT_FORMAT);
        Date d2 = DateUtils.parse("2019-05-08 12:22:33", DateUtils.DEFAULT_FORMAT);
        Date d3 = DateUtils.parse("2019-05-08 10:22:33", DateUtils.DEFAULT_FORMAT);
        Assert.assertEquals(DateUtils.addMinutes(d1, 60), d2);
        Assert.assertEquals(DateUtils.addMinutes(d1, -60), d3);

    }


}

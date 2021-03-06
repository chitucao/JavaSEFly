package cn.chitucao.test;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
//        //获取今天10点的时间
//        Date todayTime = DateUtil.offsetHour(DateUtil.beginOfDay(new Date()), 10);
//        //获取昨天10点的时间
//        Date yesterdayTime = DateUtil.offsetDay(todayTime, -1);
//        System.out.println(todayTime);
//        System.out.println(yesterdayTime);
//        testObserv();
//        testTody();
//        testMonth();
//        testyesterday();
//        testYes();
//        testSheetName();
//        testCalendar();
        testDateFormat();
    }

    static void testyesterday() {
        //昨天开始时间
        Date notifyStartTime = DateUtil.offsetDay(DateUtil.beginOfDay(new Date()), -1);
        //昨天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testObserv() {
        //昨天开始时间
        Date notifyStartTime = DateUtil.offsetDay(DateUtil.beginOfDay(new Date()), -1);
        //昨天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testMonth() {
        //一个月过期后当天开始时间
        Date notifyStartTime = DateUtil.offsetMonth(DateUtil.beginOfDay(new Date()), 1);
        //一个月过期后当天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }


    static void testTody() {
        //今天开始时间
        Date notifyStartTime = DateUtil.beginOfDay(new Date());
        //明天开始时间
        Date notifyEndTime = DateUtil.offsetDay(notifyStartTime, 1);

        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testYes() {
        Date todayStart = DateUtil.beginOfDay(new Date());  //今天开始时间
        Date yesEnd = DateUtil.offsetMillisecond(todayStart, -1);  //昨天结束时间
        System.out.println(todayStart);
        System.out.println(yesEnd);

        System.out.println(DateUtil.format(todayStart, DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(yesEnd, DatePattern.NORM_DATETIME_PATTERN));

        Date start = DateUtil.offsetMonth(new Date(), -6);
        System.out.println(start);
    }

    static void currentYear(){
        Date date = DateUtil.beginOfYear(new Date());
        System.out.println(date);
    }

    public static void testSheetName(){
//        String name = DateUtil.format(new Date(), DatePattern.CHINESE_DATE_FORMAT) + " 结算明细表";
        String wbName = DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN)
                + "-" + DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN) + " 结算明细表";
        System.out.println(wbName);
    }


    private static void testCalendar(){
        Date end = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, -2);
        Date start = calendar.getTime();
        System.out.println(DateUtil.format(start,DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end,DatePattern.NORM_DATETIME_PATTERN));

        //处理时间
        calendar.setTime(start);
        //获取当月第一天
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        start = calendar.getTime();
        //获取当月最后一天
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        end = calendar.getTime();

        System.out.println(DateUtil.format(start,DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end,DatePattern.NORM_DATETIME_PATTERN));

        end = DateUtil.endOfMonth(new Date());
        start = DateUtil.beginOfMonth(DateUtil.offsetMonth(end, -2));

        System.out.println(DateUtil.format(start,DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end,DatePattern.NORM_DATETIME_PATTERN));
    }

    private static void testDateFormat(){
        String nowStr = DateUtil.format(new Date(), "yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(nowStr);
    }

}

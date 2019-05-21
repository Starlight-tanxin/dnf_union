package com.tx.union.utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * java8 time包
 * 时间操作工具类
 *
 * @author tanxin
 * @date 2019/5/8
 */
public class DateUtils {

    /**
     * 获取当前系统日期时间
     *
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前系统日期
     *
     * @return
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * 获取本周第一天的日期时间
     * 星期1开始
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getWeekDayStart(LocalDateTime ldt) {
        // 获取今天是本周第几天
        int dayOfWeek = ldt.getDayOfWeek().getValue();
        // 本周第一天
        LocalDateTime startTime = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue(), (ldt.getDayOfMonth() - (dayOfWeek - 1)), 00, 00, 00);
        return startTime;
    }

    /**
     * 获取下周第一天的日期时间
     * 星期1开始
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getWeekDayEnd(LocalDateTime ldt) {
        // 获取今天是本周第几天
        int dayOfWeek = ldt.getDayOfWeek().getValue();
        // 本周第一天
        LocalDateTime endTime = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue(), (ldt.getDayOfMonth() + (7 - dayOfWeek + 1)), 00, 00, 00);
        return endTime;
    }


    /**
     * 获取本月第一天
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getMonthDayStart(LocalDateTime ldt) {
        LocalDateTime startTime = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue(), 1, 00, 00, 00);
        return startTime;
    }

    /**
     * 获取下个月的第一天
     * 上个月为12月则为明年的第一天
     *
     * @param ldt
     * @return
     */
    public static LocalDateTime getMonthDayEnd(LocalDateTime ldt) {
        int monthNum = ldt.getMonthValue();
        if (monthNum == 12) {
            return LocalDateTime.of(ldt.getYear() + 1, 1, 1, 00, 00, 00);
        }
        LocalDateTime endTime = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue() + 1, 1, 00, 00, 00);
        return endTime;
    }

    /**
     * 获取本季度第一天的日期时间
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getQuarterDayStart(LocalDateTime ldt) {
        int monthNum = ldt.getMonthValue();
        int startMonth = 1;
        if (1 <= monthNum && monthNum < 4) {
            startMonth = 1;
        }
        if (4 <= monthNum && monthNum < 7) {
            startMonth = 4;
        }
        if (7 <= monthNum && monthNum < 10) {
            startMonth = 7;
        }
        if (10 <= monthNum) {
            startMonth = 10;
        }

        LocalDateTime startTime = LocalDateTime.of(ldt.getYear(), startMonth, 1, 00, 00, 00);
        return startTime;
    }

    /**
     * 获取本季度的下个季度第一天的日期时间
     * Q4季度取到的为下一年的第一天
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getQuarterDayEnd(LocalDateTime ldt) {
        int monthNum = ldt.getMonthValue();
        int endMonth = 4;
        if (1 <= monthNum && monthNum < 4) {
            endMonth = 4;
        }
        if (4 <= monthNum && monthNum < 7) {
            endMonth = 7;
        }
        if (7 <= monthNum && monthNum < 10) {
            endMonth = 10;
        }
        if (10 <= monthNum) {
            return LocalDateTime.of(ldt.getYear() + 1, 1, 1, 00, 00, 00);
        }
        LocalDateTime endTime = LocalDateTime.of(ldt.getYear(), endMonth, 1, 00, 00, 00);
        return endTime;
    }

    /**
     * 获取本年第一天
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getYearDayStart(LocalDateTime ldt) {
        LocalDateTime startTime = LocalDateTime.of(ldt.getYear(), 1, 1, 00, 00, 00);
        return startTime;
    }

    /**
     * 获取下一年的第一天
     *
     * @param ldt 日期时间
     * @return
     */
    public static LocalDateTime getYearDayEnd(LocalDateTime ldt) {
        LocalDateTime endTime = LocalDateTime.of(ldt.getYear() + 1, 1, 1, 00, 00, 00);
        return endTime;
    }

    /**
     * 获取2个时间的时间差
     *
     * @param ldt  时间1
     * @param ldt2 时间2
     * @return 毫秒数
     */
    public static Long getTimeDiff(LocalDateTime ldt, LocalDateTime ldt2) {
        Duration duration = Duration.between(ldt, ldt2);
        return duration.toMillis();
    }

    /**
     * 将相差的毫秒数转成 HH：mm：ss 的 形式
     *
     * @param millis 毫秒数
     * @return
     */
    public static String MillisToHmS(Long millis) {
        // 获得小时数
        Long h = millis / (1000 * 60 * 60);
        Long m = (millis % (1000 * 60 * 60)) / (1000 * 60);
        Long s = ((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000;
        String hStr = h.toString().length() < 2 ? "0" + h.toString() : h.toString();
        String mStr = m.toString().length() < 2 ? "0" + m.toString() : m.toString();
        String sStr = s.toString().length() < 2 ? "0" + s.toString() : s.toString();
        return hStr + ":" + mStr + ":" + sStr;
    }

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2019, 3, 10, 15, 22, 36);
        LocalDateTime ldt2 = LocalDateTime.of(2019, 3, 17, 18, 32, 46);
        Long l = DateUtils.getTimeDiff(ldt, ldt2);
        System.out.println(l);
        System.out.println(DateUtils.MillisToHmS(l));
    }
}

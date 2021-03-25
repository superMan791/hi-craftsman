package com.cloud.br.hicraftsman.common.core.constant;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class DatePattern {
    public static final Pattern REGEX_NORM = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,3})?");
    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter NORM_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String NORM_TIME_PATTERN = "HH:mm:ss";
    public static final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter NORM_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";
    public static final String CHINESE_DATE_TIME_PATTERN = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String PURE_DATE_PATTERN = "yyyyMMdd";
    public static final String PURE_TIME_PATTERN = "HHmmss";
    public static final String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";
    public static final String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    public static final String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String UTC_SIMPLE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String UTC_WITH_ZONE_OFFSET_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String UTC_MS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String UTC_MS_WITH_ZONE_OFFSET_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public DatePattern() {
    }
}
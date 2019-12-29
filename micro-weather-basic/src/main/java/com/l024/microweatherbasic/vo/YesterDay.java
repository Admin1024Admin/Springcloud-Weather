package com.l024.microweatherbasic.vo;

import java.io.Serializable;

/**
 * 昨天气温
 */
public class YesterDay implements Serializable {
    /**
     * 日期
     */
    private String date;
    /**
     * 最高气温
     */
    private String high;
    /**
     * 风向
     */
    private String fx;
    /**
     * 最低气温
     */
    private String low;
    /**
     * 风级
     */
    private String fl;
    /**
     * 天气类型
     */
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "YesterDay{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", fx='" + fx + '\'' +
                ", low='" + low + '\'' +
                ", fl='" + fl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

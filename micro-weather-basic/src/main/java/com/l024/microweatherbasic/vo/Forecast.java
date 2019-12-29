package com.l024.microweatherbasic.vo;

import java.io.Serializable;

/**
 * 预测天气
 */
public class Forecast implements Serializable {
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
    private String fengxiang;
    /**
     * 最低气温
     */
    private String low;
    /**
     * 风级
     */
    private String fengli;
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

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", low='" + low + '\'' +
                ", fengli='" + fengli + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

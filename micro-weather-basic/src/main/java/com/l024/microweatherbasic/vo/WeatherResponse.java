package com.l024.microweatherbasic.vo;

import java.io.Serializable;

/**
 * 天气返回类
 */
public class WeatherResponse implements Serializable {
    private Weather data;
    private String status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

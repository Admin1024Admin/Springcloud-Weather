package com.l024.microweatherbasic.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 天气信息
 */
public class Weather implements Serializable {
    /**
     * 城市
     */
    private String city;
    /**
     * 感冒
     */
    private String ganmao;
    /**
     * 温度
     */
    private String wendu;

    /**
     * 昨日气象
     */
    private YesterDay yesterday;

    /**
     * 预测气象
     */
    private List<Forecast> forecast = new ArrayList<>();


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public YesterDay getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterDay yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", yesterday=" + yesterday +
                ", forecast=" + forecast +
                '}';
    }
}

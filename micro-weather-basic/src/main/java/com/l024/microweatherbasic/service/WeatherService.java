package com.l024.microweatherbasic.service;


import com.l024.microweatherbasic.vo.WeatherResponse;

/**
 * 天气service
 */
public interface WeatherService {

    /**
     * 根据城市id查询
     * @param cityId
     * @return
     */
    public WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名区查询
     */
    public WeatherResponse getDataByCityName(String cityName);
}

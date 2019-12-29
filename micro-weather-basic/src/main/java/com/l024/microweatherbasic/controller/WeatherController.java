package com.l024.microweatherbasic.controller;

import com.l024.microweatherbasic.service.impl.WeatherServiceImpl;
import com.l024.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取天气数据
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherServiceImpl weatherService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse egtWeatherByCityId(@PathVariable("cityId") String cityId){
       return weatherService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse egtWeatherByCityName(@PathVariable("cityName") String cityName){
         return weatherService.getDataByCityName(cityName);
    }
}

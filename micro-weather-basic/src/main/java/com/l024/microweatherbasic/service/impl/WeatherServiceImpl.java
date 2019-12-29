package com.l024.microweatherbasic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l024.microweatherbasic.service.WeatherService;
import com.l024.microweatherbasic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 天气实现类
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;
    private  static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri  = WEATHER_URL+"citykey="+cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri  = WEATHER_URL+"city="+cityName;
        return this.doGetWeather(uri);
    }

    /**
     * 封装获取数据
     */
    private WeatherResponse doGetWeather(String url){
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = "";
        if(url!=""&&url.length()>0){
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
            if(responseEntity.getStatusCodeValue()==200){
                try{
//                    strBody = StringUtil.conventFromGzip(Objects.requireNonNull(responseEntity.getBody()));
                    strBody = responseEntity.getBody();
                    System.out.println("strBody"+strBody);
                    resp = mapper.readValue(strBody.trim(),WeatherResponse.class);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return resp;
    }
}

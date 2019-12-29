package com.l024.microweatherbasic.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l024.microweatherbasic.service.WeatherService;
import com.l024.microweatherbasic.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


/**
 * 天气实现类
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    //日志
    private final static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);
    //设置过期时间
    private static final long TIME_UP = 1800;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            if(stringRedisTemplate.hasKey(url)){
                strBody = stringStringValueOperations.get(url);
                logger.info("redis中取出来");
            }else{
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
                if(responseEntity.getStatusCodeValue()==200){
                    strBody = responseEntity.getBody();
                    if(strBody!=null&&strBody.length()>0){
                        stringStringValueOperations.set(url,strBody,TIME_UP, TimeUnit.SECONDS);
                        logger.info("存入redis");
                    }
                }
            }
            try{
                resp = mapper.readValue(strBody.trim(),WeatherResponse.class);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resp;
    }
}

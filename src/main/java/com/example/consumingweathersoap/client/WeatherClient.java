package com.example.consumingweathersoap.client;

import com.example.consumingweathersoap.wsdl.GetWeatherRequest;
import com.example.consumingweathersoap.wsdl.GetWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WeatherClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

    public GetWeatherResponse getWeather(String location) {
        GetWeatherRequest request = new GetWeatherRequest();
        request.setLocation(location);

        log.info("Requesting location for " + location);

        GetWeatherResponse response = (GetWeatherResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:1235/ws/weathers", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetWeatherRequest"));

        return response;
    }
}

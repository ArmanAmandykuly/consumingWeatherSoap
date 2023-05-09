package com.example.consumingweathersoap;

import com.example.consumingweathersoap.client.WeatherClient;
import com.example.consumingweathersoap.wsdl.GetWeatherResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWeatherSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWeatherSoapApplication.class, args);
    }


    @Bean
    CommandLineRunner lookup(WeatherClient quoteClient) {
        return args -> {
            String location = "Spain";

            if(args.length > 0) {
                location = args[0];
            }
          GetWeatherResponse response = quoteClient.getWeather(location);
          System.out.println(response.getWeather().getCondition());
        };
    }

}

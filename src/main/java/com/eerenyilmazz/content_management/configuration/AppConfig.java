package com.eerenyilmazz.content_management.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, Long>() {
            @Override
            public Long convert(MappingContext<String, Long> context) {
                try {
                    return Long.parseLong(context.getSource());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        });

        return modelMapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

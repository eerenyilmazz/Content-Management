package com.eerenyilmazz.content_management.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "omdb")
@Component
@Getter
@Setter
public class OmdbProperties {

    @Value("${omdb.api.key}")
    private String apiKey;

    @Value("${omdb.url}")
    private String url;
}
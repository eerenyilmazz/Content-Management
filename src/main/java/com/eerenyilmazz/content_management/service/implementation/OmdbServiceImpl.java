package com.eerenyilmazz.content_management.service.implementation;

import com.eerenyilmazz.content_management.dto.OmdbResponse;
import com.eerenyilmazz.content_management.entity.Metadata;
import com.eerenyilmazz.content_management.service.OmdbService;
import com.eerenyilmazz.content_management.configuration.OmdbProperties;  // Import the correct package
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OmdbServiceImpl implements OmdbService {

    private final OmdbProperties omdbProperties;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Override
    public Metadata getMetadataFromOmdb(String title) {
        String url = String.format("http://www.omdbapi.com/?t=%s&apikey=%s", title, omdbProperties.getApiKey());
        OmdbResponse response = restTemplate.getForObject(url, OmdbResponse.class);
        return modelMapper.map(response, Metadata.class);
    }
}

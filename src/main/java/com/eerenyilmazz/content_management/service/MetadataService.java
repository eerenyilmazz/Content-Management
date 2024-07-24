package com.eerenyilmazz.content_management.service;

import com.eerenyilmazz.content_management.dto.MetadataDTO;
import java.util.List;

public interface MetadataService {
    MetadataDTO getMetadata(Long id);
    List<MetadataDTO> getAllMetadata();
    MetadataDTO createMetadata(MetadataDTO metadataDTO);
    MetadataDTO updateMetadataWithImdb(Long id);
}
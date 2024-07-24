package com.eerenyilmazz.content_management.service.implementation;

import com.eerenyilmazz.content_management.dto.MetadataDTO;
import com.eerenyilmazz.content_management.entity.Metadata;
import com.eerenyilmazz.content_management.repository.MetadataRepository;
import com.eerenyilmazz.content_management.service.MetadataService;
import com.eerenyilmazz.content_management.service.OmdbService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MetadataServiceImpl implements MetadataService {

    private MetadataRepository metadataRepository;
    private OmdbService omdbService;
    private ModelMapper modelMapper;

    @Override
    public MetadataDTO getMetadata(Long id) {
        Metadata metadata = metadataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metadata not found"));
        return modelMapper.map(metadata, MetadataDTO.class);
    }

    @Override
    public List<MetadataDTO> getAllMetadata() {
        return metadataRepository.findAll().stream()
                .map(metadata -> modelMapper.map(metadata, MetadataDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MetadataDTO createMetadata(MetadataDTO metadataDTO) {
        Metadata metadata = modelMapper.map(metadataDTO, Metadata.class);
        Metadata savedMetadata = metadataRepository.save(metadata);
        return modelMapper.map(savedMetadata, MetadataDTO.class);
    }

    @Override
    public MetadataDTO updateMetadataWithImdb(Long id) {
        Metadata existingMetadata = metadataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metadata not found"));
        Metadata omdbMetadata = omdbService.getMetadataFromOmdb(existingMetadata.getTitle());
        existingMetadata.setImdbId(omdbMetadata.getImdbId());
        existingMetadata.setImdbRating(omdbMetadata.getImdbRating());
        Metadata updatedMetadata = metadataRepository.save(existingMetadata);
        return modelMapper.map(updatedMetadata, MetadataDTO.class);
    }
}

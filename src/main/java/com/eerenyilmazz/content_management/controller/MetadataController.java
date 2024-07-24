package com.eerenyilmazz.content_management.controller;

import com.eerenyilmazz.content_management.dto.MetadataDTO;
import com.eerenyilmazz.content_management.service.MetadataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/metadata")
public class MetadataController {

    private MetadataService metadataService;

    @PostMapping
    public ResponseEntity<MetadataDTO> createMetadata(@RequestBody MetadataDTO metadataDTO) {
        MetadataDTO createdMetadataDTO = metadataService.createMetadata(metadataDTO);
        return ResponseEntity.ok(createdMetadataDTO);
    }

    @PostMapping("/update-imdb/{id}")
    public ResponseEntity<MetadataDTO> updateMetadataWithImdb(@PathVariable Long id) {
        MetadataDTO updatedMetadataDTO = metadataService.updateMetadataWithImdb(id);
        return ResponseEntity.ok(updatedMetadataDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetadataDTO> getMetadata(@PathVariable Long id) {
        MetadataDTO metadataDTO = metadataService.getMetadata(id);
        return ResponseEntity.ok(metadataDTO);
    }

    @GetMapping
    public ResponseEntity<List<MetadataDTO>> getAllMetadata() {
        List<MetadataDTO> metadataDTOs = metadataService.getAllMetadata();
        return ResponseEntity.ok(metadataDTOs);
    }
}
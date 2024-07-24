package com.eerenyilmazz.content_management.controller;

import com.eerenyilmazz.content_management.dto.ContentDTO;
import com.eerenyilmazz.content_management.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/contents")
public class ContentController {

    private ContentService contentService;

    @PostMapping
    public ResponseEntity<ContentDTO> createContent(@RequestBody ContentDTO contentDTO) {
        ContentDTO createdContentDTO = contentService.createContent(contentDTO);
        return ResponseEntity.ok(createdContentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDTO> updateContent(@PathVariable Long id, @RequestBody ContentDTO contentDTO) {
        ContentDTO updatedContentDTO = contentService.updateContent(id, contentDTO);
        return ResponseEntity.ok(updatedContentDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDTO> getContent(@PathVariable Long id) {
        ContentDTO contentDTO = contentService.getContent(id);
        return ResponseEntity.ok(contentDTO);
    }

    @GetMapping
    public ResponseEntity<List<ContentDTO>> getAllContents() {
        List<ContentDTO> contentDTOs = contentService.getAllContents();
        return ResponseEntity.ok(contentDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}

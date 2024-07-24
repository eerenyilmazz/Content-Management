package com.eerenyilmazz.content_management.controller;

import com.eerenyilmazz.content_management.dto.CastDTO;
import com.eerenyilmazz.content_management.service.CastService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/casts")
public class CastController {

    private CastService castService;

    @PostMapping
    public ResponseEntity<CastDTO> createCast(@RequestBody CastDTO castDTO) {
        CastDTO createdCastDTO = castService.createCast(castDTO);
        return ResponseEntity.ok(createdCastDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CastDTO> updateCast(@PathVariable Long id, @RequestBody CastDTO castDTO) {
        CastDTO updatedCastDTO = castService.updateCast(id, castDTO);
        return ResponseEntity.ok(updatedCastDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CastDTO> getCast(@PathVariable Long id) {
        CastDTO castDTO = castService.getCast(id);
        return ResponseEntity.ok(castDTO);
    }

    @GetMapping
    public ResponseEntity<List<CastDTO>> getAllCasts() {
        List<CastDTO> castDTOs = castService.getAllCasts();
        return ResponseEntity.ok(castDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCast(@PathVariable Long id) {
        castService.deleteCast(id);
        return ResponseEntity.noContent().build();
    }
}
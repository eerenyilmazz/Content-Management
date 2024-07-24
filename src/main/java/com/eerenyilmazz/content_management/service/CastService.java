package com.eerenyilmazz.content_management.service;

import com.eerenyilmazz.content_management.dto.CastDTO;
import java.util.List;

public interface CastService {
    CastDTO getCast(Long id);
    List<CastDTO> getAllCasts();
    CastDTO createCast(CastDTO castDTO);
    CastDTO updateCast(Long id, CastDTO castDTO);
    void deleteCast(Long id);
}
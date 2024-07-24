package com.eerenyilmazz.content_management.service.implementation;

import com.eerenyilmazz.content_management.dto.CastDTO;
import com.eerenyilmazz.content_management.entity.Cast;
import com.eerenyilmazz.content_management.repository.CastRepository;
import com.eerenyilmazz.content_management.service.CastService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CastServiceImpl implements CastService {

    private CastRepository castRepository;
    private ModelMapper modelMapper;

    @Override
    public CastDTO getCast(Long id) {
        Cast cast = castRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cast not found"));
        return modelMapper.map(cast, CastDTO.class);
    }

    @Override
    public List<CastDTO> getAllCasts() {
        return castRepository.findAll().stream()
                .map(cast -> modelMapper.map(cast, CastDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CastDTO createCast(CastDTO castDTO) {
        Cast cast = modelMapper.map(castDTO, Cast.class);
        Cast savedCast = castRepository.save(cast);
        return modelMapper.map(savedCast, CastDTO.class);
    }

    @Override
    public CastDTO updateCast(Long id, CastDTO castDTO) {
        Cast existingCast = castRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cast not found"));
        existingCast.setName(castDTO.getName());
        existingCast.setPoster(castDTO.getPoster());
        Cast updatedCast = castRepository.save(existingCast);
        return modelMapper.map(updatedCast, CastDTO.class);
    }

    @Override
    public void deleteCast(Long id) {
        castRepository.deleteById(id);
    }
}
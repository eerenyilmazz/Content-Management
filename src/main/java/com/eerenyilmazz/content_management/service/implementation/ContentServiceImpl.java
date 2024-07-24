package com.eerenyilmazz.content_management.service.implementation;

import com.eerenyilmazz.content_management.dto.ContentDTO;
import com.eerenyilmazz.content_management.entity.Content;
import com.eerenyilmazz.content_management.entity.Metadata;
import com.eerenyilmazz.content_management.repository.ContentRepository;
import com.eerenyilmazz.content_management.service.ContentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContentServiceImpl implements ContentService {

    private ContentRepository contentRepository;
    private ModelMapper modelMapper;

    @Override
    public ContentDTO getContent(Long id) {
        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
        return modelMapper.map(content, ContentDTO.class);
    }

    @Override
    public List<ContentDTO> getAllContents() {
        return contentRepository.findAll().stream()
                .map(content -> modelMapper.map(content, ContentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContentDTO createContent(ContentDTO contentDTO) {
        Content content = modelMapper.map(contentDTO, Content.class);
        Content savedContent = contentRepository.save(content);
        return modelMapper.map(savedContent, ContentDTO.class);
    }

    @Override
    public ContentDTO updateContent(Long id, ContentDTO contentDTO) {
        Content existingContent = contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found"));
        existingContent.setTitle(contentDTO.getTitle());
        existingContent.setPlot(contentDTO.getPlot());
        existingContent.setPoster(contentDTO.getPoster());
        existingContent.setYear(contentDTO.getYear());
        existingContent.setLanguage(contentDTO.getLanguage());
        existingContent.setCountry(contentDTO.getCountry());
        if (contentDTO.getMetadataId() != null) {
            Metadata metadata = new Metadata();
            metadata.setId(contentDTO.getMetadataId());
            existingContent.setMetadata(metadata);
        }
        Content updatedContent = contentRepository.save(existingContent);
        return modelMapper.map(updatedContent, ContentDTO.class);
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }
}
package com.eerenyilmazz.content_management.service;

import com.eerenyilmazz.content_management.dto.ContentDTO;
import java.util.List;

public interface ContentService {
    ContentDTO getContent(Long id);
    List<ContentDTO> getAllContents();
    ContentDTO createContent(ContentDTO contentDTO);
    ContentDTO updateContent(Long id, ContentDTO contentDTO);
    void deleteContent(Long id);
}
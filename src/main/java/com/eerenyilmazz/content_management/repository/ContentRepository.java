package com.eerenyilmazz.content_management.repository;

import com.eerenyilmazz.content_management.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}

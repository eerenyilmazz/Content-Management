package com.eerenyilmazz.content_management.repository;

import com.eerenyilmazz.content_management.entity.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<Metadata, Long> {
}

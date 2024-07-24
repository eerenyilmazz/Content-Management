package com.eerenyilmazz.content_management.service;

import com.eerenyilmazz.content_management.entity.Metadata;

public interface OmdbService {
    Metadata getMetadataFromOmdb(String title);
}
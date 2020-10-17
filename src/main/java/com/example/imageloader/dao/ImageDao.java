package com.example.imageloader.dao;

import com.example.imageloader.entity.ImageEntity;

import java.util.List;
import java.util.Optional;

public interface ImageDao {
    void save(ImageEntity imageEntity);

    Optional<ImageEntity> getImageWithId(String imageId);

    List<ImageEntity> getAllImages();
}

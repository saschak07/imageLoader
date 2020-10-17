package com.example.imageloader.repository;

import com.example.imageloader.entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<ImageEntity,String> {
    Optional<ImageEntity> findByImageId(String imageId);
}

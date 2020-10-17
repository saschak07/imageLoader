package com.example.imageloader.dao;

import com.example.imageloader.entity.ImageEntity;
import com.example.imageloader.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageDaoImpl implements ImageDao {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public void save(ImageEntity imageEntity) {
        imageRepository.save(imageEntity);
    }

    @Override
    public Optional<ImageEntity> getImageWithId(String imageId) {
        return imageRepository.findByImageId(imageId);
    }

    @Override
    public List<ImageEntity> getAllImages() {
        List<ImageEntity> imageEntities = new ArrayList<>();
        imageRepository.findAll().forEach(image ->imageEntities.add(image));
        return imageEntities;
    }
}

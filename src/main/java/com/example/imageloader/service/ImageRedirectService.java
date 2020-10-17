package com.example.imageloader.service;

import com.example.imageloader.dto.ImageDto;
import com.example.imageloader.dto.ImageResponseDto;

import java.util.List;

public interface ImageRedirectService {
    ImageDto getRandomImage();

    ImageDto getRandomImageWithId(String imageId);

    List<ImageResponseDto> getAllImages();
}

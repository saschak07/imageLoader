package com.example.imageloader.mapper;

import com.example.imageloader.dto.ImageDto;
import com.example.imageloader.dto.ImageResponseDto;
import com.example.imageloader.dto.Link;
import com.example.imageloader.entity.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ImageEntity dtoToEntity(ImageDto imageDto) {
        return ImageEntity.builder().id(imageDto.getId())
                .description(imageDto.getDescription())
                .imageLink(imageDto.getUrls().getRaw())
                .name(imageDto.getUser().getName())
                .userName(imageDto.getUser().getUserName())
                .build();
    }

    public ImageDto entityToDto(ImageEntity imageEntity) {
        return ImageDto.builder().urls(Link.builder().raw(imageEntity.getImageLink()).build()).build();
    }

    public ImageResponseDto entityToResponseDto(ImageEntity imageEntity) {
        return ImageResponseDto.builder().id(imageEntity.getId())
                .description(imageEntity.getDescription())
                .imageLink(imageEntity.getImageLink())
                .name(imageEntity.getName())
                .userName(imageEntity.getUserName())
                .build();
    }
}

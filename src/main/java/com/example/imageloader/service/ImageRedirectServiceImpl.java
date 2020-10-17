package com.example.imageloader.service;

import com.example.imageloader.dao.ImageDao;
import com.example.imageloader.dto.ImageDto;
import com.example.imageloader.dto.ImageResponseDto;
import com.example.imageloader.entity.ImageEntity;
import com.example.imageloader.exception.NoDataFoundException;
import com.example.imageloader.exception.RemoteResponseUnavailable;
import com.example.imageloader.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageRedirectServiceImpl implements ImageRedirectService{
    @Autowired
    private RestTemplate template;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private Mapper mapper;
    @Override
    public ImageDto getRandomImage() {
        ResponseEntity<ImageDto> imageResponse = template.exchange("https://api.unsplash.com/photos/random/?" +
                "client_id=7-atbbV9mx5kqmKqwlQo_WzfrwQ_Jg-Do-4cGJJ9Ghw", HttpMethod.GET,null,ImageDto.class);
        if(imageResponse.getStatusCode()!= HttpStatus.OK){
            throw new RemoteResponseUnavailable("No response received from upstream");
        }

        return imageResponse.getBody();
    }

    @Override
    public ImageDto getRandomImageWithId(String imageId) {
        ImageDto imageDto = null;
        try{
            Optional<ImageEntity> optionalImageEntity = imageDao.getImageWithId(imageId);
            if(!optionalImageEntity.isEmpty()){
                return mapper.entityToDto(optionalImageEntity.get());
            }
            imageDto = getRandomImage();
            ImageEntity imageEntity = mapper.dtoToEntity(imageDto);
            imageEntity.setImageId(imageId);
            imageDao.save(imageEntity);
        }catch(Exception e){
            throw new NoDataFoundException("invalid image Id");
        }
        return imageDto;
    }

    @Override
    public List<ImageResponseDto> getAllImages() {
        List<ImageResponseDto> imageEntities = imageDao.getAllImages()
                .stream().map(mapper::entityToResponseDto).collect(Collectors.toList());
        return imageEntities;
    }
}

package com.example.imageloader.controller;

import com.example.imageloader.dto.ImageDto;
import com.example.imageloader.dto.ImageResponseDto;
import com.example.imageloader.service.ImageRedirectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/imageLoader/v1")
public class ImageController {

    @Autowired
    private ImageRedirectService imageRedirectService;

    @GetMapping("/image")
    public RedirectView getRandomImage(){
        ImageDto image = imageRedirectService.getRandomImage();
        return new RedirectView(image.getUrls().getRaw());
    }
    @GetMapping("/image/id/{imageId}")
    public RedirectView getRandomImageWithId(@PathVariable String imageId){
        ImageDto image = imageRedirectService.getRandomImageWithId(imageId);
        return new RedirectView(image.getUrls().getRaw());
    }
    @GetMapping("/image/list")
    public ResponseEntity<List<ImageResponseDto>> getAllImageData(){
        List<ImageResponseDto> imageList = imageRedirectService.getAllImages();
        return ResponseEntity.ok(imageList);
    }

}

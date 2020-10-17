package com.example.imageloader.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private String id;
    private String description;
    private Link urls;
    private User user;
}

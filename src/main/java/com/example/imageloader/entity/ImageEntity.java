package com.example.imageloader.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {
    @Id
    private String id;
    private String imageId;
    private String description;
    private String imageLink;
    private String userName;
    private String name;
    @CreationTimestamp
    private Timestamp createTs;
    @UpdateTimestamp
    private Timestamp modifTimestamp;

}

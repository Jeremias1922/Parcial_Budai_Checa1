package com.dh.catalogservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document

public class Movie {
    @MongoId

    private Long id;
    private String name;
    private String genre;
    private String urlStream;
}

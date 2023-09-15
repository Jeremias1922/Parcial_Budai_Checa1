package com.dh.catalogservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Catalog {

    private List<Movie> movieList = new ArrayList<>();
    private List<Serie> serieList = new ArrayList<>();


}

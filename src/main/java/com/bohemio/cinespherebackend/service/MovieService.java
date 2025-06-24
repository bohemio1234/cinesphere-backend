package com.bohemio.cinespherebackend.service;

import com.bohemio.cinespherebackend.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> searchMovies(String query);
}

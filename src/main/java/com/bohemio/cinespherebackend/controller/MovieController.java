package com.bohemio.cinespherebackend.controller;

import com.bohemio.cinespherebackend.dto.MovieDto;
import com.bohemio.cinespherebackend.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieDto>> searchMovies(@RequestParam String query) {
        List<MovieDto> movies = movieService.searchMovies( query );
        return ResponseEntity.ok( movies );
    }

}

package com.bohemio.cinespherebackend.service;

import com.bohemio.cinespherebackend.dto.MovieDto;
import com.bohemio.cinespherebackend.dto.TmdbResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public MovieServiceImpl(RestTemplate restTemplate, @Value("${tmdb.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public List<MovieDto> searchMovies(String query) {


        URI uri = UriComponentsBuilder.fromUriString( "https://api.themoviedb.org" )
                .path( "/3/search/movie" )
                .queryParam( "query", query )
                .queryParam( "api_key", apiKey )
                .encode()
                .build()
                .toUri();

        TmdbResponseDto response = restTemplate.getForObject( uri, TmdbResponseDto.class );

        List<MovieDto> movieDtos = response.getResults();

        if (response == null || response.getResults() == null) {
            return Collections.emptyList();
        }


        return response.getResults();

    }
}

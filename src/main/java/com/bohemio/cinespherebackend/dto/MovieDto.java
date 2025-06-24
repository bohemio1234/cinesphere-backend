package com.bohemio.cinespherebackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MovieDto {

    private String title;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private Double rate;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    private String overview;

    @JsonProperty("release_date")
    private String releaseDate;

}

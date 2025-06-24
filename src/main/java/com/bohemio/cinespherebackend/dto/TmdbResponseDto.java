package com.bohemio.cinespherebackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class TmdbResponseDto {
    private List<MovieDto> results;
}

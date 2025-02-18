package com.zogg.zoggservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SplashScreenDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
}

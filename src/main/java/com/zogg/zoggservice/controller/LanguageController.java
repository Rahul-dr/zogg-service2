package com.zogg.zoggservice.controller;

import com.zogg.zoggservice.dtos.ApiResponse;
import com.zogg.zoggservice.dtos.LanguageDTO;
import com.zogg.zoggservice.service.interfaces.LanguageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping
    public ApiResponse<List<LanguageDTO>> getAllLanguages() {
        return new ApiResponse<>(
                "Languages retrieved successfully", languageService.getAllLanguages());
    }
}

package com.zogg.zoggservice.service;

import com.zogg.zoggservice.dtos.LanguageDTO;
import com.zogg.zoggservice.enums.Language;
import com.zogg.zoggservice.service.interfaces.LanguageService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Override
    public List<LanguageDTO> getAllLanguages() {
        return Arrays.stream(Language.values())
                .map(
                        language ->
                                LanguageDTO.builder()
                                        .code(language.name())
                                        .displayName(language.getDisplayName())
                                        .build())
                .collect(Collectors.toList());
    }
}

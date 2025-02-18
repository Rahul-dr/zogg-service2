package com.zogg.zoggservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigDto {
    @JsonProperty("profile_complete")
    private boolean profileComplete;

    @JsonProperty("device")
    private DeviceDto device;

    @JsonProperty("splash_screens")
    private List<SplashScreenDto> splashScreens;

    @JsonProperty("languages")
    private List<LanguageDTO> languages;
}

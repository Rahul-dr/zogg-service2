package com.zogg.zoggservice.service;

import com.zogg.zoggservice.dtos.ConfigDto;
import com.zogg.zoggservice.dtos.DeviceDto;
import com.zogg.zoggservice.dtos.SplashScreenDto;
import com.zogg.zoggservice.entity.User;
import com.zogg.zoggservice.repository.UserRepository;
import com.zogg.zoggservice.service.interfaces.ConfigService;
import java.util.List;

import com.zogg.zoggservice.service.interfaces.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigServiceImpl implements ConfigService {

    private final UserRepository userRepository;
    private final LanguageService languageService;

    @Override
    public ConfigDto getConfiguration(String deviceId) {
        // First check if device exists
        User user = userRepository.findByDeviceId(deviceId);
        boolean isProfileComplete = false;

        if (user != null && user.getPhoneNumber() != null) {
            // Get user by phone number to ensure association
            User userByPhone = userRepository.findByPhoneNumber(user.getPhoneNumber());
            if (userByPhone != null) {
                isProfileComplete = userByPhone.getFirstName() != null && !userByPhone.getFirstName().trim().isEmpty();
            }
        }

        return ConfigDto.builder()
                .profileComplete(isProfileComplete)
                .device(getDeviceValidation(deviceId))
                .splashScreens(getSplashScreens())
                .languages(languageService.getAllLanguages())
                .build();
    }

    private DeviceDto getDeviceValidation(String deviceId) {
        boolean isExist = userRepository.existsByDeviceId(deviceId);
        return DeviceDto.builder().deviceId(deviceId).isExist(isExist).build();
    }

    private List<SplashScreenDto> getSplashScreens() {
        return List.of(
                SplashScreenDto.builder()
                        .id(1L)
                        .title("Play fun & exciting games")
                        .description("Complete milestones to earn coins")
                        .imageUrl("/assets/images/splash/games.png")
                        .build(),
                SplashScreenDto.builder()
                        .id(2L)
                        .title("Refer your friends & earn bonus coins")
                        .description("More referrals = More exclusive rewards!")
                        .imageUrl("/assets/images/splash/referral.png")
                        .build(),
                SplashScreenDto.builder()
                        .id(3L)
                        .title("Buy exclusive vouchers from top brands")
                        .description("Redeem coins for discounts & special offers")
                        .imageUrl("/assets/images/splash/vouchers.png")
                        .build());
    }
}
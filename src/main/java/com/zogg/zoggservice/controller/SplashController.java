package com.zogg.zoggservice.controller;

import com.zogg.zoggservice.dtos.ApiResponse;
import com.zogg.zoggservice.dtos.SplashScreenDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/splash")
public class SplashController {

    @GetMapping
    public ApiResponse<List<SplashScreenDto>> getSplashScreens() {
        List<SplashScreenDto> splashScreens =
                List.of(
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

        return new ApiResponse<>("Splash screens retrieved successfully", splashScreens);
    }
}

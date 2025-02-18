package com.zogg.zoggservice.controller;

import com.zogg.zoggservice.dtos.ApiResponse;
import com.zogg.zoggservice.dtos.ConfigDto;
import com.zogg.zoggservice.service.interfaces.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/get-config")
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigService configService;

        @GetMapping("/{device_id}")
        public ApiResponse<ConfigDto> getConfig(@PathVariable("device_id") String deviceId) {
            return new ApiResponse<>(
                    "Configuration retrieved successfully",
     configService.getConfiguration(deviceId));
        }

//    @GetMapping
//    public ApiResponse<ConfigDto> getConfig(@RequestParam("device_id") String deviceId) {
//        return new ApiResponse<>(
//                "Configuration retrieved successfully", configService.getConfiguration(deviceId));
//    }
}

package com.zogg.zoggservice.controller;

import com.zogg.zoggservice.dtos.ApiResponse;
import com.zogg.zoggservice.dtos.DeviceDto;
import com.zogg.zoggservice.service.interfaces.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/devices")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @PostMapping("/validate")
    public ApiResponse<?> validateDevice(@Valid @RequestBody DeviceDto deviceDto) {
        return new ApiResponse<>(
                "Device validation completed", deviceService.validateDevice(deviceDto));
    }
}

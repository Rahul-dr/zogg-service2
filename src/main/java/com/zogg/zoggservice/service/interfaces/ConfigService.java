package com.zogg.zoggservice.service.interfaces;

import com.zogg.zoggservice.dtos.ConfigDto;

public interface ConfigService {
    ConfigDto getConfiguration(String deviceId);
}

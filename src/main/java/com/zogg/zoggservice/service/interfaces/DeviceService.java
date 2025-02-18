package com.zogg.zoggservice.service.interfaces;

import com.zogg.zoggservice.dtos.DeviceDto;
import java.util.Map;

public interface DeviceService {
    Map<String, Object> validateDevice(DeviceDto deviceDto);
}

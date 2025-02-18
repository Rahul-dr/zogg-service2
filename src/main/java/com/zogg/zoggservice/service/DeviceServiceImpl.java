package com.zogg.zoggservice.service;

import com.zogg.zoggservice.dtos.DeviceDto;
import com.zogg.zoggservice.repository.UserRepository;
import com.zogg.zoggservice.service.interfaces.DeviceService;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {
    private final UserRepository userRepository;

    @Override
    public Map<String, Object> validateDevice(DeviceDto deviceDto) {
        boolean isValid = userRepository.existsByDeviceId(deviceDto.getDeviceId());

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("device_id", deviceDto.getDeviceId());
        resultMap.put("is_valid", isValid);

        return resultMap;
    }
}

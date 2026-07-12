package com.project.uber.Service;

import com.project.uber.Repository.UberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class uberStatusService {

    @Autowired
    UberRepository uberRepository;
    public String getUberStatus(String string) {
        return uberRepository.SaveStatus(string);
    }

}

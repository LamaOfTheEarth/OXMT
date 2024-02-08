package com.oxmt.machineagevalidator.controller;


import com.oxmt.machineagevalidator.dto.MachineAgeDTO;
import com.oxmt.machineagevalidator.service.OutlierDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class MachineAgeValidationController {

    @Autowired
    private OutlierDetectionService outlierDetection;

    @PostMapping("/validate-machine-ages")
    public List<MachineAgeDTO> validateMachineAges(@RequestBody List<MachineAgeDTO> machineAges) {

        // Perform outlier detection using DBSCAN from SCAN library
        return outlierDetection.detectOutliers(machineAges);
    }


}

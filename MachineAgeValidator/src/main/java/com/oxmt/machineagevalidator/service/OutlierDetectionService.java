package com.oxmt.machineagevalidator.service;


import com.oxmt.machineagevalidator.dto.MachineAgeDTO;
import org.springframework.stereotype.Service;
import smile.clustering.DBSCAN;

import java.util.ArrayList;
import java.util.List;

@Service
public class OutlierDetectionService {

    public List<MachineAgeDTO> detectOutliers(List<MachineAgeDTO> machineAges) {
        List<MachineAgeDTO> outliers = new ArrayList<>();

        // Convert ages to numerical values (in days)
        double[] numericalAges = new double[machineAges.size()];
        for (int i = 0; i < machineAges.size(); i++) {
            numericalAges[i] = parseAge(machineAges.get(i).getAge());
        }

        // create data for DBSCAN
        double[][] data = new double[numericalAges.length][1];
        for (int i = 0; i < numericalAges.length; i++) {
            data[i][0] = numericalAges[i];
        }

        // Use DBSCAN for outlier detection
        DBSCAN dbscan = DBSCAN.fit(data, 1, 2);
        int[] labels = dbscan.y;
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == DBSCAN.OUTLIER) {
                outliers.add(machineAges.get(i));
            }
        }

        return outliers;

    }

    private double parseAge(String ageString) {
        String[] parts = ageString.split(" ");
        double value = Double.parseDouble(parts[0]);
        String unit = parts[1];

        // Convert all units to a unified scale, for example, years
        switch (unit) {
            case "day":
                return value / 365.0;
            case "days":
                return value / 365.0;
            case "months":
                return value / 12.0;
            case "month":
                return value / 12.0;
            case "years":
                return value;
            case "year":
                return value;
            default:
                throw new IllegalArgumentException("Unknown time unit: " + unit);
        }
    }

}

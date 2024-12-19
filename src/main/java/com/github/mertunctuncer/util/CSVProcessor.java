package com.github.mertunctuncer.util;

import java.util.Set;

public class CSVProcessor {

    public CSVData normalize(CSVData csvData, float min, float max, Set<Integer> ignoredColumnIndex) {

        float[][] data = csvData.getData();
        String[] columns = csvData.getColumns();

        float[][] normalizedData = new float[data.length][columns.length];

        for(int j = 0; j < columns.length; j++) {

            if(ignoredColumnIndex.contains(j)) continue;

            for(int i = 0; i < data.length; i++) {
                normalizedData[i][j] = (max - min) * ((data[i][j] - csvData.getMin()[j]) / (csvData.getMax()[j] - csvData.getMin()[j])) + min;
            }
        }

        return new CSVData(columns, normalizedData);
    }
}

package com.github.mertunctuncer.util;

import com.github.mertunctuncer.data.DataMatrix;

import java.util.Set;

public class MatrixProcessor {

    public DataMatrix normalize(DataMatrix dataMatrix, float min, float max, Set<Integer> ignoredColumnIndex) {

        float[][] data = dataMatrix.getArray();
        String[] columns = dataMatrix.getColumns();

        float[][] normalizedData = new float[data.length][columns.length];

        for(int columnIndex = 0; columnIndex < columns.length; columnIndex++) {

            if(ignoredColumnIndex.contains(columnIndex)) continue;

            for(int rowIndex = 0; rowIndex < data.length; rowIndex++) {
                normalizedData[rowIndex][columnIndex] = (max - min) * ((data[rowIndex][columnIndex] - dataMatrix.getMinValues()[columnIndex]) / (dataMatrix.getMaxValues()[columnIndex] - dataMatrix.getMinValues()[columnIndex])) + min;
            }
        }

        return new DataMatrix(columns, normalizedData);
    }
}

package com.github.mertunctuncer.classification;

import com.aparapi.Kernel;
import java.util.Set;

import com.aparapi.Range;
import com.github.mertunctuncer.util.CSVData;

public class KNearestNeighbour {

    public void findClosest(CSVData data, float[] search, Set<Integer> ignoredIndexes) {
        float[][] distSquared = new float[data.getRowSize()][data.getColumnSize()];
        float[][] dataArray = data.getData();

        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                for(int j = 0; j < data.getColumnSize(); j++) {
                    if(ignoredIndexes.contains(j)) continue;
                    distSquared[i][j] = pow(dataArray[i][j] - search[j], 2);
                }
            }
        };

        Range range = Range.create(distSquared.length);
        kernel.execute(range);



    }
}

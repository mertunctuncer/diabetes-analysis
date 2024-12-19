package com.github.mertunctuncer.classification;

import com.aparapi.Kernel;

import java.util.Set;

import com.aparapi.Range;
import com.github.mertunctuncer.data.DataMatrix;
import com.github.mertunctuncer.util.Distance;

public class KNearestNeighbour {

    public DataMatrix findClosest(DataMatrix data, float[] search, int k, Set<Integer> ignoredIndexes) {

        float[][] dataArray = data.getArray();
        float[] distances = new float[dataArray.length];

        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                distances[i] = Distance.getEuclideanDistance(dataArray[i], search);
            }
        };

        Range range = Range.create(data.getRowSize());
        kernel.execute(range);

        int[] closestIndexes = closestK(distances, k);

        float[][] closestData = new float[closestIndexes.length][data.getColumnSize()];

        for(int i = 0; i < closestIndexes.length; i++) {
            closestData[i] = dataArray[closestIndexes[i]];
        }

        return new DataMatrix(data.getColumns(), closestData);
    }

    private int[] closestK(float[] distances, int k) {
        // return indexes of the smallest k in distances array


    }


}

package com.github.mertunctuncer.util;

public class Distance {

    public static float getEuclideanDistance(float[] a, float[] b) {

        double total = 0;
        for(int i = 0; i < b.length; i++) {
            total += Math.pow(a[i] - b[i], 2);
        }

        return (float) Math.sqrt(total);
    }
}

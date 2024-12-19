package com.github.mertunctuncer.util;

public class CSVData {

    private final String[] columns;
    private final float[][] data;
    private final float[] min;
    private final float[] max;

    public CSVData(String[] columns, float[][] data) {
        this.columns = columns;
        this.data = data;
        this.min = new float[columns.length];
        this.max = new float[columns.length];
        findMinMax();
    }

    private void findMinMax() {
        for(int i = 0; i < columns.length; i++) {
            min[i] = Float.MAX_VALUE;
            max[i] = Float.MIN_VALUE;
        }

        for(float[] row : data) {
            for(int i = 0; i < columns.length; i++) {
                if(row[i] > max[i]) {
                    max[i] = row[i];
                } else if (row[i] < min[i]) {
                    min[i] = row[i];
                }
            }
        }

    }

    public String[] getColumns() {
        return columns;
    }

    public float[][] getData() {
        return data;
    }

    public float[] getMax() {
        return max;
    }

    public float[] getMin() {
        return min;
    }

    public int getRowSize() {
        return data.length;
    }

    public int getColumnSize() {
        return columns.length;
    }
}

package com.github.mertunctuncer.data;

public class DataMatrix {

    private final String[] columns;
    private final float[][] data;
    private final float[] min;
    private final float[] max;

    public DataMatrix(String[] columns, float[][] data) {
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

    public float get(int row, int column) {
        return data[row][column];
    }

    public String[] getColumns() {
        return columns;
    }

    public float[][] getArray() {
        return data;
    }

    public float[] getMaxValues() {
        return max;
    }

    public float[] getMinValues() {
        return min;
    }

    public int getRowSize() {
        return data.length;
    }

    public int getColumnSize() {
        return columns.length;
    }
}

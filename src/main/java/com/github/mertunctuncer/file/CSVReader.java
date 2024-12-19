package com.github.mertunctuncer.file;

import com.github.mertunctuncer.data.DataMatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CSVReader {

    private final Path path;
    private final String[] columnNames;
    private final int columnCount;
    private final int rowCount;

    public CSVReader(Path path) {
        this.path = path;
        try {
            columnNames = readColumnNames();
            columnCount = findColumnCount();
            rowCount = findRowCount();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public DataMatrix readFile() throws IOException {
        float[][] data;
        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            data = new float[rowCount - 1][columnCount];

            int index = 0;
            reader.readLine();
            while((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                for(int i = 0; i < columnNames.length; i++) {
                    data[index][i] = Float.parseFloat(split[i]);
                }
                index++;
            }
        }

        return new DataMatrix(columnNames, data);
    }

    private String[] readColumnNames() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String firstLine = reader.readLine();
            return firstLine.split(",");
        }
    }

    private int findRowCount() throws IOException {
        try (Stream<String> lineStream = Files.lines(path, StandardCharsets.UTF_8)) {
            return (int) lineStream.count();
        }
    }

    private int findColumnCount() {
        return columnNames.length;
    }
}

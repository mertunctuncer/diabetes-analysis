package com.github.mertunctuncer.util;

import com.github.mertunctuncer.Main;
import com.github.mertunctuncer.data.DataMatrix;
import com.github.mertunctuncer.file.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class CSVReaderTest {

    @Test
    void fileReadCorrectly() {

        Assertions.assertDoesNotThrow(() -> {
            CSVReader reader = new CSVReader(Paths.get(Main.class.getClassLoader().getResource("diabetes_012.csv").toURI()));
            DataMatrix data = reader.readFile();
            Assertions.assertEquals(0, data.get(0,0));
            Assertions.assertEquals(40.0, data.get(0,4));
            Assertions.assertEquals(22, data.getColumnSize());
        });
    }
}
package com.github.mertunctuncer.util;

import com.github.mertunctuncer.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class CSVReaderTest {

    @Test
    void fileReadCorrectly() {

        Assertions.assertDoesNotThrow(() -> {
            CSVReader reader = new CSVReader(Paths.get(Main.class.getClassLoader().getResource("diabetes_012.csv").toURI()));
            reader.readFile();
            Assertions.assertEquals(0, reader.getData()[0][0]);
            Assertions.assertEquals(40.0, reader.getData()[0][4]);
            Assertions.assertEquals(22, reader.getColumnCount());
        });
    }
}
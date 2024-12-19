package com.github.mertunctuncer;

import com.aparapi.Kernel;
import com.aparapi.Range;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Kernel kernel = new Kernel() {

            @Override
            public void run() {
                int id = getGlobalId();
            }
        };


        Range range = Range.create(250000);

        kernel.execute(range);
    }
}
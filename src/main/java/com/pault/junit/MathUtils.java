package com.pault.junit;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class MathUtils {

    public int add(int a, int b) {
        return (a + b);
    }

    public int multiply(int a, int b) {
        return (a * b);
    }

    public int[] multipleInt(int a) {
        int[] z = new int[a];
        for (int x = 1; x < a; x++) {
            z[x] = x;
        }
        return z;
    }

    public List listWithNames() {
        List<String> names = new ArrayList<>();
        names.add("Paul");
        names.add("Caitlin");
        names.add("Rory");
        return names;
    }

    public double computeCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}

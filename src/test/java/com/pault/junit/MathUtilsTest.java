package com.pault.junit;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void tearDown() {
        mathUtils = null;
    }

    @Test
    void add() {
        int expected = 3;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    void multiply() {
        int expected = 21;
        int actual = mathUtils.multiply(3, 7);
        assertEquals(expected, actual);
    }

    @Test
    void multipleInt() {
        int[] expected = new int[]{0, 1, 2, 3};
        int[] actual = mathUtils.multipleInt(4);
        assertArrayEquals(expected, actual);

    }

    @Test
    void listWithNames() {
        List<String> expected = new ArrayList<>();
        expected.add("Paul");
        expected.add("Caitlin");
        expected.add("Rory");

        List<String> actual = new ArrayList<>();
        actual.add("Paul");
        actual.add("Caitlin.. ");
        actual.add("Rory");
        assertIterableEquals(expected, actual);

    }

   @Test
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return correct radius");

   }


}
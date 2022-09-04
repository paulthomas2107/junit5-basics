package com.pault.junit;

import lombok.extern.java.Log;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Log
@DisplayName("When running MathUtil")
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
    @Disabled
    @DisplayName("I do nothing")
    void doNothing() {

    }
    @Test
    void add() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);
    }

    @Test
    void addAgain() {
        int expected = 100;
        int actual = mathUtils.add(98, 2);
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
    @DisplayName("Test with possible lambda if fails")
    void multipleWithMessageLambda() {
        int expected = 100;
        int actual = mathUtils.multiply(10, 10);
        // Lambda added
        assertEquals(expected, actual, () -> "This should be 100");
    }

    @Test
    void listWithNames() {
        List<String> expected = new ArrayList<>();
        expected.add("Paul");
        expected.add("Caitlin");
        expected.add("Rory");

        List<String> actual = new ArrayList<>();
        actual.add("Paul");
        actual.add("Caitlin");
        actual.add("Rory");
        assertIterableEquals(expected, actual);

    }

   @RepeatedTest(5) // Runs test 5 times
    void testComputeCircleRadius() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return correct radius");

   }

   @Nested
   @DisplayName("Inline Class started....")
   @Tag("Math") // can be run exclusively as Math Test....change surefire maven needs
   class AddingTest {
       @Test
       @DisplayName("Normal Add")
       @Tag("Math")
       void addFromInner() {
           int expected = 2;
           int actual = mathUtils.add(1, 1);
           assertEquals(expected, actual);
       }

       @Test
       @DisplayName("More adds....")
       @Tag("Math")
       void addAgainFromInner() {
           int expected = 100;
           int actual = mathUtils.add(98, 2);
           assertEquals(expected, actual);
       }
   }


}
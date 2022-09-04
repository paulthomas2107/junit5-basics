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
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {

        this.testInfo = testInfo;
        this.testReporter = testReporter;

        mathUtils = new MathUtils();

        // Test Reporter - writes to the actual Junit logging
        testReporter.publishEntry("Running=======> "+testInfo.getTestClass() + " " + testInfo.getDisplayName());

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
    @DisplayName("Plain Add")
    void add() {
        // Use TestInfo and TestReporter
        log.info("Running "+testInfo.getTestClass() + " with name of "+testInfo.getDisplayName());
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

    @Test
    @DisplayName("Run Multiples")
    void runMultiplesOfMultiply() {
        // Test Reporter - writes to the actual Junit logging
        testReporter.publishEntry("Running=======> "+testInfo.getTestClass());
        assertAll(
                () -> assertEquals(10, mathUtils.multiply(5, 2)),
                () -> assertEquals(20, mathUtils.multiply(5, 4)),
                () -> assertEquals(1000, mathUtils.multiply(10, 100)),
                () -> assertEquals(98, mathUtils.multiply(14, 7))
        );


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
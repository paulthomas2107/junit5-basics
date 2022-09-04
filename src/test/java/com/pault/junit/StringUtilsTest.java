package com.pault.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        StringUtils stringUtils = new StringUtils();
    }

    @AfterEach
    void tearDown() {
        stringUtils = null;

    }

    @Test
    void reverseMyName() {
        String expected = "luaP";
        String actual = stringUtils.reverseMyName("Paul");
        assertEquals(expected, actual, "Should be reverse of name");
    }
}
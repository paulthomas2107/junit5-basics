package com.pault.junit;

import lombok.extern.java.Log;

@Log
public class StringUtils {

    public static String reverseMyName(String name) {
        return new StringBuilder(name).reverse().toString();
    }
}

package com.kkambi.racing.util;

public class TypeChecker {

    private TypeChecker() {
        throw new AssertionError();
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package com.kkambi.racing.util;

/**
 * 타입 체크를 위한 유틸리티 클래스.
 *
 * @author KKambi
 */
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

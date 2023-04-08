package com.next.step.step2;

public class StringCalculatorValidation {

    private static final String NOT_INCLUDE_NEGATIVE = "입력에 음수 값이 포함되면 안됩니다.";

    private static final String NOT_NUMBER_INPUT = "숫자 이외의 값이 입력돼 수정이 필요합니다.";

    private static final String IS_NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    public static void validateNegativeValue(Integer stringToNumber) {
        if (stringToNumber < 0) {
            throw new RuntimeException(NOT_INCLUDE_NEGATIVE);
        }
    }

    public static void validateNumber(String splitNumber) {
        if (!splitNumber.matches(IS_NUMBER_REGEX)) {
            throw new RuntimeException(NOT_NUMBER_INPUT);
        }
    }
}

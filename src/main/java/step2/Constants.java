package step2;

import java.util.function.Supplier;

public final class Constants {
    public static final Integer ZERO = 0;

    // 숫자와 사칙 연산 사이의 구분을 빈 공백으로 가정
    public static final String SPLIT_DELIMITER = "\\s";
    public static final String NUMBERS_AND_FOUR_OPERATOR_CALCULATION_REGEXP = "[0-9|+|\\-|*|/|\\s]*";

    public static final Supplier<IllegalArgumentException> ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER =
            () -> new IllegalArgumentException("사칙 연산에 해당하는 문자열이 존재하지 않습니다.");

    public static final String STRING_NOT_FOUND_EXCEPTION = "값이 존재하지 않습니다.";
    public static final String CANNOT_CALCULATE_FORMULA = "연산할 수 없는 공식입니다.";
}

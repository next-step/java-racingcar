package step2;

import java.util.function.Supplier;

public final class Constants {
    public static final Integer ZERO = 0;

    // 숫자와 사칙 연산 사이의 구분을 빈 공백으로 가정
    public static final String SPLIT_DELIMITER = "\\s";
    public static final String REGEXP = "[0-9|\\+|\\-|\\*|\\/|\\s]*";

    public static final Supplier<IllegalArgumentException> ILLEGAL_ARGUMENT_EXCEPTION_SUPPLIER =
            () -> new IllegalArgumentException("사칙 연산에 해당하는 문자열이 존재하지 않습니다.");
}

package edu.nextstep.camp.carracing;

public class StringUtils {
    private static final String DEFAULT_DELIMITER = ",";

    private StringUtils() {
        throw new IllegalStateException("인스턴스 생성이 불가능한 클래스입니다.");
    }

    public static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}

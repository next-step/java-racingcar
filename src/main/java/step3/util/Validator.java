package step3.util;

/**
 * 입력 문자열 유효성 검사 유틸 클래스
 */
public final class Validator {
    private Validator() { }

    public static boolean isNullAndIsBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}

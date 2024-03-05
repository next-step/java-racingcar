package util;

/**
 * 문자열 덧셈 계산기
 */
public class StringAddCalculator {

    /**
     * 문자열을 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
     *
     * @param value 문자열
     * @return 분리한 숫자의 합. 단, null이나 빈 문자열의 경우 0을 반환한다.
     */
    public static int splitAndSum(String value) {
        if (isBlank(value)) {
            return 0;
        }

        throw new RuntimeException();
    }

    private static boolean isBlank(String value) {
        return value == null
                || value.isEmpty();
    }

}

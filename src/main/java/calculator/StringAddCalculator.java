package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String exp) {

        // 빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.
        if (validateInputValue(exp)) {
            return 0;
        }

        return 0;
    }

    private static boolean validateInputValue(String exp) {
        return exp == null || exp.isEmpty();
    }
}

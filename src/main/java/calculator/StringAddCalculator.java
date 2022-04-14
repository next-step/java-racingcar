package calculator;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        // 빈 문자일 경우 기본 값인 0 리턴
        if (StringValidation.isBlank(text)) {
            return DEFAULT_VALUE;
        }

        String[] values = StringSplit.split(text);
        return StringCalculation.sum(StringCasting.toInts(values));
    }

}

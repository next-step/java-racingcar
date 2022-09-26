package nextstep.javaracingcar.step2;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new AssertionError("해당 객체는 생성이 불가합니다.");
    }

    public static PositiveNumber calculate(final String input) {

        if (isBlank(input)) {
            return PositiveNumber.ZERO;
        }

        final StringCalculatorInput stringCalculatorInput = new StringCalculatorInput(input);

        PositiveNumber sum = PositiveNumber.ZERO;
        for (final PositiveNumber positiveNumber : stringCalculatorInput.toNumbers()) {
            sum = sum.plus(positiveNumber);
        }
        return sum;
    }

    private static boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }
}

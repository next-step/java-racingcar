package nextstep.javaracingcar.step2;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static PositiveNumber calculate(final String input) {

        if (isBlank(input)) {
            return PositiveNumber.ZERO;
        }

        final StringCalculatorInput stringCalculatorInput = new StringCalculatorInput(input);

        PositiveNumber sum = PositiveNumber.ZERO;
        for (final PositiveNumber positiveNumber : stringCalculatorInput.values()) {
            sum = sum.plus(positiveNumber);
        }
        return sum;
    }

    private static boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }
}

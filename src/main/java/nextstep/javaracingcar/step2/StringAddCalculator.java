package nextstep.javaracingcar.step2;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static PositiveNumber calculate(final String input) {

        if (isBlank(input)) {
            return PositiveNumber.ZERO;
        }

        final StringCalculatorInput stringCalculatorInput = new StringCalculatorInput(input);

        PositiveNumber accumulator = PositiveNumber.ZERO;
        for (final PositiveNumber positiveNumber : stringCalculatorInput.values()) {
            accumulator = accumulator.plus(positiveNumber);
        }
        return accumulator;
    }

    private static boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }
}

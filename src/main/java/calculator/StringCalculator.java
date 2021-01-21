package calculator;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public double calculate(final String expressionString) throws IllegalArgumentException {
        validateNonNullOrBlank(expressionString);
        String[] elements = expressionString.split(DELIMITER);
        validateOddNumberOfElements(elements);

        double result = Converter.toDouble(elements[0]);
        for (int i = 1; i < elements.length; i += 2) {
            String operator = elements[i];
            double num = Converter.toDouble(elements[i + 1]);
            result = Operator.calculate(operator, result, num);
        }
        return result;
    }

    private void validateNonNullOrBlank(final String expressionString) {
        if (expressionString == null || expressionString.isBlank()) {
            throw new IllegalArgumentException("수식이 없습니다.");
        }
    }

    private void validateOddNumberOfElements(final String[] elements) {
        if (elements.length % 2 != 1) {
            throw new IllegalArgumentException("올바른 수식이 아닙니다.");
        }
    }
}

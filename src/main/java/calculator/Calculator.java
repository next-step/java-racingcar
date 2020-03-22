package calculator;

public class Calculator {

    private static final String REGEX = " ";

    public static double calculate(String input) {
        String[] split = input.split(REGEX);

        checkFormulaLength(split.length);
        double result = stringToDouble(split[0]);
        for (int i = 0; i < split.length - 1; i += 2) {
            double y = stringToDouble(split[i + 2]);
            Operator operator = Operator.getOperator(split[i + 1]);
            result = operator.apply(result, y);
        }
        return result;
    }

    private static void checkFormulaLength(int length) {
        if (length < 3 || length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static double stringToDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("non numeric values");
        }
    }
}

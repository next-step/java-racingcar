package calculator.domain;

public class CalculatorCore {

    private static int result = 0;

    public static int createExpression(String[] values) throws RuntimeException {

        result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            result = calculate(result, values[i], values[i + 1]);
        }

        return result;
    }

    public static int calculate(int beforeValue, String operator, String nextValue) throws RuntimeException {

        CalculatorOperator calculatorOperator = CalculatorOperator.getEnumNameByString(operator);

        if (calculatorOperator == null) {
            throw new RuntimeException("해당 연산자 없음");
        }

        if (calculatorOperator == CalculatorOperator.DIVISION) {
            checkByZero(nextValue);
        }

        return calculatorOperator.calculate(beforeValue, Integer.valueOf(nextValue));
    }

    public static void checkByZero(String nextValue) {
        if ("0".equals(nextValue)) {
            throw new RuntimeException("0으로는 나눌 수 없음");
        }
    }

}

package calculator;

public class Calculator {

    public static int calculate(String[] expression) {
        final int expressionLength = expression.length;
        for (int i = 0; i < expressionLength - 1; i += 2) {
            int firstOperand = Integer.parseInt(expression[i]);
            String operator = expression[i + 1];
            int secondOperand = Integer.parseInt(expression[i + 2]);
            int result = calculateIndividual(firstOperand, secondOperand, operator);
            expression[i + 2] = Integer.toString(result);
        }
        return Integer.parseInt(expression[expressionLength - 1]);
    }

    private static int calculateIndividual(int firstOperand, int secondOperand, String symbol) {
        Operator operator = Operator.findByOperator(symbol);
        return operator.operate(firstOperand, secondOperand);
    }

}

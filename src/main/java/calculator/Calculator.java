package calculator;

public class Calculator {

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String expression = InputView.inputString();
        String[] expressions = InputView.parsing(expression);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(expressions);
        System.out.println(result);
    }

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

    private static int calculateIndividual(int firstOperand, int secondOperand, String operator) {
        if (operator.equals("+")) {
            return Operator.ADD.getCalculable().calculate(firstOperand, secondOperand);
        }
        if (operator.equals("-")) {
            return Operator.SUB.getCalculable().calculate(firstOperand, secondOperand);
        }
        if (operator.equals("*")) {
            return Operator.MUL.getCalculable().calculate(firstOperand, secondOperand);
        }
        if (operator.equals("/")) {
            return Operator.DIV.getCalculable().calculate(firstOperand, secondOperand);
        }
        throw new IllegalArgumentException("Error: need right operator");
    }

}

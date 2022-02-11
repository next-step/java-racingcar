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
            int result = caculateIndividual(firstOperand, secondOperand, operator);
            expression[i + 2] = Integer.toString(result);
        }
        return Integer.parseInt(expression[expressionLength - 1]);
    }

    public static int caculateIndividual(int firstOperand, int secondOperand, String operator) {
        int result = 0;
        if (operator.equals("+")) {
            result = add(firstOperand, secondOperand);
        } else if (operator.equals("-")) {
            result = sub(firstOperand, secondOperand);
        } else if (operator.equals("*")) {
            result = mul(firstOperand, secondOperand);
        } else if (operator.equals("/")) {
            if (secondOperand == 0) {
                throw new IllegalArgumentException("Error: can't divide zero");
            } else {
                result = div(firstOperand, secondOperand);
            }
        } else {
            throw new IllegalArgumentException("Error: need right operator");
        }
        return result;
    }

    public static int add(int firstOperand, int secondOperand) {

        return firstOperand + secondOperand;
    }

    public static int sub(int firstOperand, int secondOperand) {

        return firstOperand - secondOperand;
    }

    public static int mul(int firstOperand, int secondOperand) {

        return firstOperand * secondOperand;
    }

    public static int div(int firstOperand, int secondOperand) {

        return firstOperand / secondOperand;
    }
}

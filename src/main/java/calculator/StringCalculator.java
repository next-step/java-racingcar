package calculator;

public class StringCalculator {
    public static int calculaor(String text) {
        String[] values = text.split(" ");
        int sum = Integer.parseInt(values[0]);

        for (int idx = 1; idx < (values.length + 1) / 2; idx++) {
            String operator = values[idx * 2 - 1];
            int right = Integer.valueOf(values[idx * 2]);

            sum = operate(operator, sum, right);
        }
        return sum;
    }

    private static int operate(String operator, int leftOperand, int rightOperand) {
        if ("+".equals(operator)) {
            return leftOperand + rightOperand;
        }
        if ("-".equals(operator)) {
            return leftOperand - rightOperand;
        }
        if ("/".equals(operator)) {
            return leftOperand / rightOperand;
        }
        if ("*".equals(operator)) {
            return leftOperand * rightOperand;
        }
        throw new IllegalArgumentException();
    }

}

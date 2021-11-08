package step2;

public class Calculator {

    public int calculate(Expression expression) {
        int ans = expression.nextInt();

        while (expression.canCalculate()) {
            String operator = expression.nextOperator();
            int second = expression.nextInt();

            ans = calculate(operator, ans, second);
        }

        return ans;
    }

    private int calculate(String operator, int first, int second) {
        if (operator.equals("+")) {
            return first + second;
        }
        if (operator.equals("-")) {
            return first - second;
        }
        if (operator.equals("*")) {
            return first * second;
        }
        if (operator.equals("/")) {
            return first / second;
        }
        throw new IllegalArgumentException();
    }
}

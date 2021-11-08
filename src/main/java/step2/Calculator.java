package step2;

public class Calculator {

    public int calculate(Expression expression) {
        int ans = expression.nextInt();

        while (expression.canCalculate()) {
            int second = expression.nextInt();
            String operator = expression.nextOperator();

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

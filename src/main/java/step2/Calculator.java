package step2;

public class Calculator {

    public static MyNumber calculate(Expression expression) {
        MyNumber ans = expression.nextInt();

        while (expression.canCalculate()) {
            MyNumber second = expression.nextInt();
            String operator = expression.nextOperator();

            ans = calculate(operator, ans, second);
        }

        return ans;
    }

    private static MyNumber calculate(String operator, MyNumber first, MyNumber second) {
        if (operator.equals("+")) {
            return first.plus(second);
        }
        if (operator.equals("-")) {
            return first.minus(second);
        }
        if (operator.equals("*")) {
            return first.multiply(second);
        }
        if (operator.equals("/")) {
            return first.divide(second);
        }
        throw new IllegalArgumentException();
    }
}

package step2;

public class Calculator {

    public static Operand calculate(Expression expression) {
        Operand ans = expression.nextOperand();
        while (expression.hasNext()) {
            Operand nextOperand = expression.nextOperand();
            Operator operator = expression.nextOperator();

            ans = operator.operate(ans, nextOperand);
        }

        return ans;
    }
}

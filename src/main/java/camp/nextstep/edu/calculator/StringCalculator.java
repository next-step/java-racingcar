package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static int operate(String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }
        return Integer.parseInt(expression);
    }
}

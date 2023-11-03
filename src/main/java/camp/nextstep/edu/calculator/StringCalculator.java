package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static int calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }
        String[] values = expression.split(",");
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}

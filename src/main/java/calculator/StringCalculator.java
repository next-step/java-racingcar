package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static List<Operation> operations = new ArrayList<>();
    static {
        operations.add(new PlusOperation());
        operations.add(new MinusOperation());
        operations.add(new MultipleOperation());
        operations.add(new DivideOperation());
    }

    public static int calculate(String value) {
        String[] values = value.split(" ");
        int result = toInt(values[0]);
        for(int i=1; i < values.length; i+=2) {
            String operator = values[i];
            int second = toInt(values[i + 1]);
            result = calculate(result, second, operator);
        }
        return result;
    }

    private static int calculate(int first, int second, String operator) {
        Operator op = Operator.of(operator);
        return op.operate(first, second);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}

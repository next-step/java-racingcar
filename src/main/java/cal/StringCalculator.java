package cal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class StringCalculator {

    private static final Map<String, BinaryOperator<Integer>> operatorMap;

    static {
        operatorMap = new HashMap<String, BinaryOperator<Integer>>() {{
            put("+", (x, y) -> x + y);
            put("-", (x, y) -> x - y);
            put("*", (x, y) -> x * y);
            put("/", (x, y) -> x / y);
        }};
    }

    public static int calculate(String input) {
        if (isNull(input) || isBlank(input)) {
            throw new IllegalArgumentException();
        }

        String[] tokenArray = input.split(" ");

        int result = Integer.parseInt(tokenArray[0]);

        int tokenArrayLength = tokenArray.length;
        for (int i = 1; i < tokenArrayLength; i += 2) {
            String sign = tokenArray[i];
            int operand = Integer.parseInt(tokenArray[i + 1]);
            if (!operatorMap.containsKey(sign)) {
                throw new IllegalArgumentException();
            }
            result = operatorMap.get(sign).apply(result, operand);
        }

        return result;
    }

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isBlank(String input) {
        return input.trim().equals("");
    }
}

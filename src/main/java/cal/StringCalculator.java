package cal;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    interface Operation {
        int calculate(int a, int b);
    }

    public static int calculateStringEquation(String input) {
        if (isNull(input) || isBlank(input)) {
            throw new IllegalArgumentException();
        }

        Map<String, Operation> operatorMap = new HashMap<>();
        operatorMap.put("+", (x, y) -> x + y);
        operatorMap.put("-", (x, y) -> x - y);
        operatorMap.put("*", (x, y) -> x * y);
        operatorMap.put("/", (x, y) -> x / y);

        String[] tokenArray = input.split(" ");

        int result = Integer.parseInt(tokenArray[0]);

        int tokenArrayLength = tokenArray.length;
        for (int i = 1; i < tokenArrayLength; i += 2) {
            String sign = tokenArray[i];
            int operand = Integer.parseInt(tokenArray[i + 1]);
            if (!operatorMap.containsKey(sign)) {
                throw new IllegalArgumentException();
            }
            result = operatorMap.get(sign).calculate(result, operand);
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

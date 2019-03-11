package calculator;

import java.util.Arrays;

public class StringCalculator {
    static int calculate(String calculation){
        if(calculation == null || calculation.equals("")){
            throw new IllegalArgumentException();
        }

        int[] operands = extractOperands(calculation);
        char[] operators = extractOperators(calculation);

        if(operands.length == operators.length-1){
            throw new IllegalStateException();
        }

        int result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result = calculate(result, operands[i], operators[i-1]);
        }

        return result;
    }

    private static int calculate(int i, int j, char operator) {
        if(operator == '+'){
            return i + j;
        }
        if(operator == '-'){
            return i - j;
        }
        if(operator == '*'){
            return i * j;
        }
        if(operator == '/'){
            return i / j;
        }

        throw new IllegalArgumentException();
    }

    private static int[] extractOperands(String calculation){
        return Arrays.stream(calculation.split("[+\\-*/]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static char[] extractOperators(String calculation){
        return String.join("", calculation.split("[0-9]+")).toCharArray();
    }
}

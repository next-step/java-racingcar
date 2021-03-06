package stringCalculator;

import java.util.Arrays;
import java.util.HashSet;

public class StringCalculator {
    final String DELIMITER = " ";
    final HashSet<String> FOUR_RULE_OPERATOR_SET = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int calculate(String input) {
        String[] splitedInput = checkParam(input);
        int result = Integer.parseInt(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i+=2) {
            result = operation(splitedInput[i], result, Integer.parseInt(splitedInput[i+1]));
        }
        return result;
    }

    private int operation(String operator, int number1, int number2) {
        switch (operator){
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return 0;
    }

    private String[] checkParam(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input is null or empty");
        }
        String[] validateResult = input.split(DELIMITER);
        if (validateResult.length % 2 == 0) {
            throw new IllegalArgumentException("calculating param counts is not odd number");
        }
        for (int i = 0; i < validateResult.length; i++) {
            if (i % 2 == 0) {
                try {
                    Integer.parseInt(validateResult[i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("calculating param is wrong : contained not number or wrong opterator");
                }
            } else if (!FOUR_RULE_OPERATOR_SET.contains(validateResult[i])) {
                throw new IllegalArgumentException("calculating param is wrong : contained not number or wrong opterator");
            } else if ("/".equals(validateResult[i]) && Integer.parseInt(validateResult[i+1])==0) {
                throw new IllegalArgumentException("calculating param is wrong : can't divide by 0");
            }
        }
        return validateResult;
    }
}


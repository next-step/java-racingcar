package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Calculator {

    private int a = Integer.MIN_VALUE;
    private int b = Integer.MIN_VALUE;

    private String operand = "";

    private int add(int a, int b) {
        return a + b;
    }

    private int substract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }


    public int calculator(String input) {
        inputIsNumllOrEmptyCheck(input);

        List<String> inputString = getStrings(input);

        return stringCalculator(inputString);
    }

    private int stringCalculator(List<String> inputString) {
        a = Integer.parseInt(inputString.get(0));
        inputString.remove(0);
        while (!inputString.isEmpty()) {
            operand = operandValidCheck(inputString.get(0));
            inputString.remove(0);
            b = Integer.parseInt(inputString.get(0));
            a = excuteCalulator(a, b, operand);
            inputString.remove(0);
        }
        return a;
    }

    private List<String> getStrings(String input) {
        List<String> inputString = new ArrayList<>();
        inputString.addAll(List.of(input.split(" ")));
        return inputString;
    }

    private String operandValidCheck(String operand) {
        if (!(operand.equals("+") || operand.equals("-") || operand.equals("*") || operand.equals(
            "/"))) {
            throw new IllegalArgumentException("사칙연산 기호가 아닌 기호가 포함되어있습니다. (" + operand + ")");
        }
        return operand;
    }

    private int excuteCalulator(int a, int b, String operand) {
        if (operand.equals("+")) {
            return add(a, b);
        }
        if (operand.equals("-")) {
            return substract(a, b);
        }
        if (operand.equals("*")) {
            return multiply(a, b);
        }
        if (operand.equals("/")) {
            return divide(a, b);
        }
        return 0;
    }

    private void inputIsNumllOrEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
    }

}
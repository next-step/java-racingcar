package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private int a = Integer.MIN_VALUE;
    private int b = Integer.MIN_VALUE;

    private String operand = "";

    public int calculator(String input) {
        inputIsNumllOrEmptyCheck(input);

        operandValidCheck(input);

        List<String> inputString = getStrings(input);

        return stringCalculator(inputString);
    }

    private int stringCalculator(List<String> input) {
        a = Integer.parseInt(input.get(0));
        input.remove(0);
        while (!input.isEmpty()) {
            operand = input.get(0);
            input.remove(0);
            b = Integer.parseInt(input.get(0));
            a = excuteCalulator(a, b, operand);
            input.remove(0);
        }
        return a;
    }

    private List<String> getStrings(String input) {
        List<String> inputString = new ArrayList<>();
        inputString.addAll(List.of(input.split(" ")));

        return inputString;
    }

    private int excuteCalulator(int a, int b, String operand) {
        if (operand.equals("+")) {
            return a + b;
        }
        if (operand.equals("-")) {
            return a - b;
        }
        if (operand.equals("*")) {
            return a * b;
        }
        if (operand.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
        throw new IllegalArgumentException("사칙연산의 연산자가 아닌 문자가 입력되었습니다.");
    }

    private void inputIsNumllOrEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
        }
    }

    public List<String> operandValidCheck(String input) {
        List<String> inputString = new ArrayList<>();
        inputString.addAll(List.of(input.split(" ")));

        List<String> stringStream = inputString.stream().filter((item)
            ->
            item.compareTo("+") != 0
                && item.compareTo("-") != 0
                && item.compareTo("*") != 0
                && item.compareTo("/") != 0
                && !(item.matches("[0-9]+"))
        ).collect(Collectors.toList());

        if (!stringStream.isEmpty()) {
            throw new IllegalArgumentException("사칙연산 기호가 아닌 기호가 포함되어있습니다.");
        }

        return inputString;
    }
}
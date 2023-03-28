package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int calculator(String input) {
        inputIsNumllOrEmptyCheck(input);

        operandValidCheck(input);

        List<String> inputString = getStrings(input);

        return stringCalculator(inputString);
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

    private List<String> getStrings(String input) {
        return new ArrayList<>(List.of(input.split(" ")));
    }

    private int stringCalculator(List<String> input) {
        int a = 0;
        int b = 0;
        String operator = "";

        a = Integer.parseInt(input.get(0));
        input.remove(0);
        while (!input.isEmpty()) {
            operator = input.get(0);
            input.remove(0);
            b = Integer.parseInt(input.get(0));
            a = Operator.calculate(a, b, operator);
            input.remove(0);
        }
        return a;
    }
}
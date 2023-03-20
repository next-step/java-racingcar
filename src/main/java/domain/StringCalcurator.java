package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringCalcurator {
    public List<Integer> getNumbers(List<String> input) {
        return input.stream()
                .filter(number -> number.matches("[0-9]"))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    public List<String> getSigns(List<String> input) {
        return input.stream()
                .filter(number -> number.matches("[+\\-/*%]"))
                .collect(Collectors.toList());
    }

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
    }

    private List<String> getListString(String input) {
        return Arrays.asList(input.split(" "));
    }

    public int calc(String strInput) {
        validateInput(strInput);
        List<String> input = getListString(strInput);
        validateNumberAndSign(input);

        return calc(input);
    }

    private int calc(List<String> input) {
        List<Integer> numbers = getNumbers(input);
        List<String> signs = getSigns(input);

        return initCalcurator(numbers, signs);
    }

    private void validateNumberAndSign(List<String> input) {

        if (input.stream().filter(sign -> sign.matches("[+\\-/*%]")).count() + input.stream()
                .filter(number -> number.matches("[0-9]")).count() != input.size())
            throw new IllegalArgumentException("연산자는 덧셈 뺄셈 곱셉 나눗셈만 입력 가능 합니다.");

        if (input.stream().filter(sign -> sign.matches("[+\\-/*%]")).count() != input.stream()
                .filter(number -> number.matches("[0-9]")).count() - 1)
            throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");

        if (input.stream().filter(number -> number.matches("[0-9]")).count() < 2)
            throw new IllegalArgumentException("숫자는 최소 2개 이상이어야 합니다.");

    }

    private int initCalcurator(List<Integer> numbers, List<String> signs) {
        int initNumber = numbers.get(0);
        numbers.remove(0);

        return numbers.stream()
                .reduce(initNumber, (result, number) -> {
                    int reduceResult = calcurator(result, signs.get(0), number);
                    signs.remove(0);
                    return reduceResult;
                });
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calcurator(int result, String sign, int number) {
        if (sign.equals("+"))
            return add(result, number);
        if (sign.equals("-"))
            return subtract(result, number);
        if (sign.equals("*"))
            return multiply(result, number);
        if (sign.equals("/"))
            return divide(result, number);

        return 0;
    }
}

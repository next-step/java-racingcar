package calculator;

import java.util.*;

public class StringCalculator {

    private final String SEPARATOR = " ";

    private Queue<Operator> symbols = new LinkedList<>();
    private List<Integer> numbers = new ArrayList<>();

    public int arithmeticOperation(String input) {
        emptyCheck(input);
        String[] inputArr = input.split(SEPARATOR);
        collectSymbolAndNumber(inputArr);
        validationCheck();
        return calculate();
    }

    private int calculate() {
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            Operator operator = symbols.poll();
            if (operator == null) {
                return result;
            }
            result = operator.exec(result, numbers.get(i));
        }
        return result;
    }

    private void collectSymbolAndNumber(String[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            if (isOdd(i)) {
                addSymbol(inputArr[i]);
            } else {
                addNumber(inputArr[i]);
            }
        }
    }

    private void addNumber(String value) {
        try {
            numbers.add(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid value - number format exception");
        }
    }

    private void addSymbol(String value) {
        Operator operator = Operator.of(value);
        if (operator == null) {
            throw new IllegalArgumentException("invalid value - operator null exception");
        }
        symbols.offer(operator);
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private void emptyCheck(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("invalid value - input empty exception");
        }
    }

    private void validationCheck() {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("invalid value - numbers quantity exception");
        }
    }
}

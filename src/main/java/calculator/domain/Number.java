package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private List<Integer> numbers;

    private Number() {
        numbers = new ArrayList<>();
    }

    public static Number get() {
        return new Number();
    }

    public void addNumber(String num) {
        for (char c : num.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new NumberFormatException(NOT_NUMBER_MESSAGE);
            }
        }
        numbers.add(Integer.valueOf(num));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void clear() {
        this.numbers.clear();
    }
}

package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private List<Integer> numbers;

    private Numbers() {
        numbers = new ArrayList<>();
    }

    public static Numbers get() {
        return new Numbers();
    }

    public void addNumber(String number) {
        for (char digit : number.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new NumberFormatException(NOT_NUMBER_MESSAGE);
            }
        }
        numbers.add(Integer.valueOf(number));
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

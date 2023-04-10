package calculator;

import exception.NegativeNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveNumber {
    private static final Pattern pattern = Pattern.compile("-?[0-9]+");

    private final int number;

    public PositiveNumber(String input) {
        validateInput(input);
        validateNegative(input);
        this.number = Integer.parseInt(input);
    }

    private PositiveNumber(int number) {
        this.number = number;
    }

    public PositiveNumber add(PositiveNumber number) {
        return new PositiveNumber(this.number + number.number);
    }

    public int convertToInt() {
        return this.number;
    }

    private void validateInput(String input) {
        Matcher matcher = pattern.matcher(input);
        if(!matcher.find()) {
            throw new RuntimeException("숫자로 변환될 수 없는 입력값입니다.");
        }
    }

    private void validateNegative(String input) {
        if(Integer.parseInt(input) < 0) {
            throw new NegativeNumberException("음수값은 입력할 수 없습니다.");
        }
    }
}

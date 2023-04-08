package calculator;

import exception.NegativeNumberException;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(String input) {
        int number = Integer.parseInt(input);
        validateNumber(number);
        this.number = number;
    }

     public int number() {
        return this.number;
     }

    private void validateNumber(int number) {
        if(number < 0) {
            throw new NegativeNumberException("음수값은 입력할 수 없습니다.");
        }
    }
}

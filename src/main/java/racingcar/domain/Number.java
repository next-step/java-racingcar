package racingcar.domain;

public class Number {
    private final int postiveNumber;

    public Number(String input) {
        this.postiveNumber = validate(parse(input));
    }

    private int validate(int number) {
        if (number > 0) {
            return number;
        }

        throw new IllegalArgumentException("0보다 큰 값을 입력해야합니다.");
    }

    private int parse(String textNumber) {
        try {
            return (Integer.parseInt(textNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다." + e.getMessage());
        }
    }

    public int getNumber() {
        return postiveNumber;
    }
}

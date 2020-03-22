package racingcar;

public class InputValidation {
    private final int number;

    public InputValidation(String number) {
        checkInputNullOrEmpty(number);
        this.number = parseToNumber(number);
        checkPositiveNumber(this.number);
    }

    private void checkInputNullOrEmpty(String inputText) {
        if (inputText == null || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException("빈값이 입력되었습니다.");
        }
    }

    private int parseToNumber(String textNumber) {
        try {
            return (Integer.parseInt(textNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void checkPositiveNumber (int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력해야합니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}

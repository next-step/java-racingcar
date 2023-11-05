package calculator;

public class PositiveNumber {
    private int value;

    public PositiveNumber(String text) {
        this.value = checkInteger(text);
    }

    private int checkInteger(String text) {
        int result = checkNumber(text);
        negative(result);
        return result;
    }

    private int checkNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다..", e);
        }
    }

    private void negative(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
    }

    public int value() {
        return value;
    }
}

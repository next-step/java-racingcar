package calculator;

public final class Positive {

    private final int num;

    public Positive(int inputNumber) {
        validatePositiveNumber(inputNumber);
        num = inputNumber;
    }

    private void validatePositiveNumber(int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException("양수 값을 입력해 주세요");
        }
    }

    protected int getNum() {
        return num;
    }
}

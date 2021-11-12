package study.step_2;

import java.util.Objects;

public class InputNumber {

    private final int inputNumber;

    public InputNumber(int number) {
        this.inputNumber = number;
    }

    public InputNumber(String text) {
        this(Integer.parseInt(text));
    }

    public int getInputNumber() {
        return this.inputNumber;
    }

    public InputNumber add(InputNumber second) {
        return new InputNumber(this.inputNumber + second.inputNumber);
    }

    public InputNumber subtract(InputNumber second) {
        return new InputNumber(this.inputNumber - second.inputNumber);
    }

    public InputNumber multiply(InputNumber second) {
        return new InputNumber(this.inputNumber * second.inputNumber);
    }

    public InputNumber divide(InputNumber second) {
        validate(second);
        return new InputNumber(this.inputNumber / second.inputNumber);
    }

    private void validate(InputNumber second) {
        if(second.inputNumber == 0) {
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumber that = (InputNumber) o;
        return inputNumber == that.inputNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputNumber);
    }
}

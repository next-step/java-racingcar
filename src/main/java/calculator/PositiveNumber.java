package calculator;

import java.util.Objects;

public class PositiveNumber {
    private final int value;

    public int getValue() {
        return value;
    }

    public PositiveNumber(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("NEGATIVE NUMBER");
        }
        this.value = value;
    }

    public static PositiveNumber from(int value){
        return new PositiveNumber(value);
    }

    public static PositiveNumber from(String text){
        return new PositiveNumber(Integer.parseInt(text));
    }

    public PositiveNumber plus(int number){
        return new PositiveNumber(this.value + number);
    }

    public PositiveNumber plus(PositiveNumber positiveNumber){
        return new PositiveNumber(this.value + positiveNumber.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

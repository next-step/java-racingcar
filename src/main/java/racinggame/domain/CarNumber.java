package racinggame.domain;

import java.util.Objects;

public class CarNumber {
    private int number;

    public CarNumber() {
        this(0);
    }

    public CarNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("0보다 작은 값이 될 수 없습니다.");
        }
        this.number = number;
    }

    public void increase() {
        this.number++;
    }

    public void decrease() {
        this.number--;
    }

    public boolean isPositive() {
        return this.number > 0;
    }

    public CarNumber max(int that) {
        return new CarNumber(Math.max(this.number, that));
    }

    public CarNumber max(CarNumber that) {
        return max(that.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarNumber number1 = (CarNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "CarNumber{" +
                "number=" + number +
                '}';
    }
}

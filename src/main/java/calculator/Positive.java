package calculator;

import java.util.Objects;

public class Positive {
    private int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        this.number = number;
    }
    // 버그 가능성 존재
    public Positive plus(int number) {
        this.number += number;
        return this;
    }

    // 불변, 성능 저하
    public Positive plus(Positive number) {
        return new Positive(this.number + number.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positive positive = (Positive) o;
        return number == positive.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}

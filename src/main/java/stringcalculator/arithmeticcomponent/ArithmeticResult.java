package stringcalculator.arithmeticcomponent;

import java.util.Objects;

/**
 * 1회 연산의 숫자 결과
 */
class ArithmeticResult {
    private int number;

    ArithmeticResult(int number) {
        this.number = number;
    }

    int number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArithmeticResult that = (ArithmeticResult) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

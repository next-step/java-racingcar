package calculator;

import java.util.Objects;

public class CalNumber {

    private final int number;

    public CalNumber(String number) {
        this(Integer.parseInt(number));
    }

    public CalNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public CalNumber calculate(CalNumber to, String operation) {
        return Operator.of(operation).apply(this, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalNumber calNumber = (CalNumber) o;
        return number == calNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

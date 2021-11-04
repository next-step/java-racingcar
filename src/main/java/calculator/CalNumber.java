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


    private CalNumber plusBy(CalNumber calNumber) {
        return new CalNumber(this.number + calNumber.number);
    }

    private CalNumber minusBy(CalNumber calNumber) {
        return new CalNumber(this.number - calNumber.number);
    }

    private CalNumber multipleBy(CalNumber calNumber) {
        return new CalNumber(this.number * calNumber.number);
    }

    private CalNumber dividedBy(CalNumber calNumber) {
        return new CalNumber(this.number / calNumber.number);
    }

    public CalNumber calculate(CalNumber to, String operation) {
        if (operation.equals("+")) {
            return plusBy(to);
        }

        if (operation.equals("-")) {
            return minusBy(to);
        }

        if (operation.equals("*")) {
            return multipleBy(to);
        }

        if (operation.equals("/")) {
            return dividedBy(to);
        }

        throw new IllegalArgumentException("operation이 잘못되었습니다.");
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

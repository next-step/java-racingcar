package step2;

import java.util.Objects;

public class MyNumber {

    private final static String numbersOnlyRegex = "^[0-9]*$";

    private int number;

    public MyNumber(String text) {
        this(StringToInteger(text));
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber plus(MyNumber other) {
        return new MyNumber(this.number + other.number);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber multiply(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber divide(MyNumber other) {
        divideValidation(other);

        return new MyNumber(this.number / other.number);
    }

    public int getNumber() {
        return number;
    }

    public static void validNumber(String text) {
        if(Common.textNullOrEmpty(text)) {
            throw new IllegalArgumentException(MyException.INVALID_NUMBER.getMessage());
        }

        if(!text.matches(numbersOnlyRegex)) {
            throw new IllegalArgumentException(MyException.INVALID_NUMBER.getMessage());
        }
    }

    public void divideValidation(MyNumber other) {
        if(this.number == 0) {
            throw new IllegalArgumentException(MyException.ZERO_NOT_DIVIDE.getMessage());
        }

        if(other.number == 0) {
            throw new IllegalArgumentException(MyException.NOT_DIVIDE_BY_ZERO.getMessage());
        }

        if((this.number % other.number) != 0) {
            throw new IllegalStateException(MyException.NOT_DROP_TO_INTEGER.getMessage());
        }
    }

    public static int StringToInteger(String text) {
        validNumber(text);

        return Integer.parseInt(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyNumber myNumber = (MyNumber) o;
        return number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

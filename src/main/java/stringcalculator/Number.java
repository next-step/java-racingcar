package stringcalculator;

public class Number {
    private final int number;

    private Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력 해주세요");
        }
    }

    private Number (int number) {
        this.number = number;
    }

    public static Number from(String num) {
        return new Number(num);
    }

    public Number plus(Number other) {
        return new Number(this.number + other.number);
    }
    public Number minus(Number other) {
        return new Number(this.number - other.number);
    }

    public Number multiply(Number other) {
        return new Number(this.number * other.number);
    }

    public Number divide(Number other) {
        return new Number(this.number / other.number);
    }

    public int getNumber() {
        return number;
    }
}

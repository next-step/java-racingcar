package calculator;

public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        this(Integer.parseInt(number));
    }

    public Number plus(Number other) {
        return new Number(this.number + other.number);
    }

    public Number minus(Number other) {
        return new Number(this.number - other.number);
    }

    public Number times(Number other) {
        return new Number(this.number * other.number);
    }

    public Number dividedBy(Number other) {
        if (other.number == 0)
            throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
        return new Number(this.number / other.number);
    }

    public int getNumber() {
        return number;
    }

    public boolean equals(Number other) {
        return this.number == other.number;
    }

}

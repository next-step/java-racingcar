package stringcalculator;

public class MyNumber {
    private final int number;

    public MyNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public MyNumber add(MyNumber other) {
        return new MyNumber(this.number + other.number);
    }

    public MyNumber minus(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber multiply(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber dividedBy(MyNumber other) {
        if (other.number == 0) {
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        return new MyNumber(this.number / other.number);
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}

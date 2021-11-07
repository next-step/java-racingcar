package calculator;

public class MyNumber {
    private final int number;

    public MyNumber(String number) {
        this.number = Integer.parseInt(number);
    }

    public MyNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public MyNumber add(MyNumber other) {
        return new MyNumber(this.number + other.number);
    }

    public MyNumber subtraction(MyNumber other) {
        return new MyNumber(this.number - other.number);
    }

    public MyNumber multiplication(MyNumber other) {
        return new MyNumber(this.number * other.number);
    }

    public MyNumber division(MyNumber other) {
        if (other.number == 0) {
            throw new IllegalArgumentException("denominator cannot used zero.");
        }
        return new MyNumber(this.number / other.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null | getClass() != obj.getClass()) return false;
        MyNumber myNumber = (MyNumber) obj;
        return this.number == myNumber.number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

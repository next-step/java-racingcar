package calculator;

public class Calculator {

    private final int number;

    public Calculator(String st) {
        this(Integer.parseInt(st));
    }

    public Calculator(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Calculator plus(Calculator number2) {
        return new Calculator(this.number + number2.number);
    }

    public Calculator minus(Calculator number2) {
        return new Calculator(this.number - number2.number);
    }

    public Calculator multiple(Calculator number2) {
        return new Calculator(this.number * number2.number);
    }

    public Calculator divide(Calculator number2) {
        if(number2.number == 0) {
            throw new IllegalArgumentException("number should not be 0");
        }
        return new Calculator(this.number / number2.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}

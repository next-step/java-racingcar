package calculator;

public class MyInteger {

    private final int value;

    public MyInteger(String value) {
        this(Integer.parseInt(value));
    }

    public MyInteger(int value) {
        this.value = value;
    }

    public MyInteger add(MyInteger operand) {
        return new MyInteger(this.value + operand.value);
    }

    public MyInteger subtract(MyInteger operand) {
        return new MyInteger(this.value - operand.value);
    }

    public MyInteger multiply(MyInteger operand) {
        return new MyInteger(this.value * operand.value);
    }

    public MyInteger divide(MyInteger operand) {
        if (operand.equals(new MyInteger(0))) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return new MyInteger(this.value / operand.value);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.value == ((MyInteger) obj).value;
    }

}

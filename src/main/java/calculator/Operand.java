package calculator;

public class Operand {

    private final int value;

    private final static Operand ZERO_VALUE = new Operand(0);

    public Operand(String value) {
        this(Integer.parseInt(value));
    }

    public Operand(int value) {
        this.value = value;
    }

    public Operand add(Operand operand) {
        return new Operand(this.value + operand.value);
    }

    public Operand subtract(Operand operand) {
        return new Operand(this.value - operand.value);
    }

    public Operand multiply(Operand operand) {
        return new Operand(this.value * operand.value);
    }

    public Operand divide(Operand operand) {
        if (operand.equals(ZERO_VALUE)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return new Operand(this.value / operand.value);
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Operand)) {
            return false;
        }
        Operand other = (Operand) o;

        return other.value == this.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.value);
    }
}

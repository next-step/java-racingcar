package study.calculator;

public class Operand {
    public int value;

    Operand(int value) {
        this.value = value;
    }

    public static Operand of(int value) {
        return new Operand(value);
    }

    public static Operand of(String value) {
        return new Operand(Integer.parseInt(value));
    }
}

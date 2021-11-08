package step2;

public class Operand {

    private final int value;

    private Operand(int value) {
        this.value = value;
    }

    public static Operand from(String value) {
        try {
            return new Operand(Integer.parseInt(value));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");

        }
    }


    int getValue() {
        return value;
    }

    Operand plus(Operand b) {
        return new Operand(this.value + b.getValue());
    }

    Operand minus(Operand b) {
        return new Operand(this.value - b.getValue());
    }

    Operand times(Operand b) {
        return new Operand(this.value * b.getValue());
    }

    Operand dividedBy(Operand b) {
        return new Operand(this.value / b.getValue());
    }
}

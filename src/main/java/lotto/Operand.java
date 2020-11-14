package lotto;

public class Operand {
    private final Integer value;

    public Operand(String value) {
        if (Integer.parseInt(value) < 0) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_CREATE_NEGATIVE_OPERAND);
        }
        this.value = Integer.valueOf(value);
    }

    public Integer getValue() {
        return this.value;
    }
}

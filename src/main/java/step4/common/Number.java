package step4.common;

public enum Number {
    ZERO(0),
    ONE(1),
    TWO(2);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

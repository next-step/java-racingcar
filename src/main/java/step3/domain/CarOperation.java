package step3.domain;

public enum CarOperation {

    GO(1), STOP(0);

    private static final int BOUND = 4;
    private int value;

    CarOperation(int value) {
        this.value = value;
    }

    public static CarOperation from(int number) {
        if (number >= BOUND) {
            return GO;
        }
        return STOP;
    }

    public int getValue() {
        return value;
    }

}
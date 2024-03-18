package race.domain;

public final class Position {

    private int value;

    public static Position createInstance(int number) {
        return new Position(number);
    }

    private Position(final int value) {
        this.value = value;
    }


    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public boolean isEqual(int number) {
        return value == number;
    }

    public int max(int number) {
        return Math.max(value, number);
    }
}

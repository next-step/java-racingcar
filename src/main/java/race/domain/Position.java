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

    public int max(int number) {
        return Math.max(value, number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return value == position.value;
    }
}

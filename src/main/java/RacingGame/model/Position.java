package RacingGame.model;

public final class Position {

    private static final int LOW = 0;
    private static final int HIGH = 10;
    private static final Position[] CACHE;

    static {
        int size = HIGH + 1;
        CACHE = new Position[size];
        for (int i = LOW; i <= HIGH; i++) {
            CACHE[i] = new Position(i);
        }
    }

    public Position() {
        this(0);
    }

    private final int number;

    public Position(int number) {
        this.number = number;
    }

    public int getPosition() {
        return this.number;
    }

    public Position increase() {
        return Position.valueOf(this.number + 1);
    }

    public boolean isValueEquals(int number) {
        return this.number == number;
    }

    public static Position valueOf(int number) {
        if (number >= LOW && number <= HIGH) {
            return CACHE[number];
        }
        return new Position(number);
    }
}

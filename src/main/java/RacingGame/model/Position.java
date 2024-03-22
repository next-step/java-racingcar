package RacingGame.model;

public class Position {
    private int number;

    public Position() {
        this(0);
    }

    public Position(int number) {
        this.number = number;
    }

    public int getPosition() {
        return this.number;
    }

    public void increase() {
        this.number++;
    }

    public boolean isValueEquals(int number) {
        return this.number == number;
    }

    private static class PositionCache {
        static final int low = 0;
        static final int high = 10;
        static final Position[] cache;

        static {
            int size = high + 1;
            Position[] positions = new Position[size];
            for (int i = 0; i < positions.length; i++) {
                positions[i] = new Position(i);
            }

            cache = positions;
        }
    }

    public static Position valueOf(int number) {
        if (number >= PositionCache.low && number <= PositionCache.high) {
            return PositionCache.cache[number];
        }
        return new Position(number);
    }
}

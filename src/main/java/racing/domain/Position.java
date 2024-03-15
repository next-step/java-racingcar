package racing.domain;

public class Position {
    private static final int START_POSITION = 0;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position startPosition() {
        return new Position(START_POSITION);
    }

    public static Position valueOf(int position) {
        return new Position(position);
    }

    public Position add(int addPosition) {
        return new Position(position + addPosition);
    }

    public int getPosition() {
        return position;
    }

    public int max(int targetNumber) {
        return Math.max(position, targetNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return position == ((Position) obj).position;
        }
        return false;
    }
}

package racing;

public class Position {
    private static final int START_POSITION = 0;

    private final int position;

    public Position() {
        this.position = START_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public Position add(int addPosition) {
        return new Position(position + addPosition);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            return position == ((Position) obj).position;
        }
        return false;
    }
}

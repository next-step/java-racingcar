package game.domain;

public class Position {

    public static final int DEFAULT_POSITION = 0;
    private final int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(final String position) {
        this(Integer.parseInt(position));
    }

    public Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    private static void validatePosition(final int position) {
        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException("0 이상인 숫자만 유효합니다.");
        }
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public boolean isMaxPosition(final int maxPosition) {
        return this.position == maxPosition;
    }

    public int maxPosition(final int position) {
        return Math.max(this.position, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }

    public int getPosition() {
        return position;
    }
}

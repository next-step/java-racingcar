package game.domain;

public class Position implements Comparable<Position> {

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

    @Override
    public int compareTo(final Position comparePosition) {
        return this.position - comparePosition.getPosition();
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

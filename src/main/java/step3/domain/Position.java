package step3.domain;

public class Position implements Comparable<Position> {
    private final int position;
    /**
     * @param position only zero or positive number
     */
    public Position(final int position) {
        if (position < 0) throw new IllegalArgumentException("position은 0보다 작을 수 없습니다");
        this.position = position;
    }

    public int intValue() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Position) {
            return ((Position) obj).position == this.position;
        }

        return false;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(position, o.position);
    }
}

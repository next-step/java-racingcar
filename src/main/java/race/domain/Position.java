package race.domain;

public class Position {

    private static final int INCREASE = 1;
    private int position;

    public Position(int position) {
        if (position < 0)
            throw new IllegalArgumentException("위치 값은 0 이상이여야 합니다.");
        this.position = position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Position))
            return false;
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return this.position;
    }

    public Position move() {
        position += INCREASE;
        return this;
    }

    public int getMax(int max) {
        return Math.max(max, this.position);
    }

    public boolean isSamePosition(int max) {
        return this.position == max;
    }

    public int getPosition() {
        return this.position;
    }
}

package racing.domain.car;

public class Position {

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position increase() {
        return new Position(this.value + 1); //피드백 반영
    }

    public int maxPosition(int maxPosition) {
        if (this.value < maxPosition) {
            return maxPosition;
        }
        return this.value;
    }

    public boolean isSame(int maxPosition) {
        return this.value == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

}

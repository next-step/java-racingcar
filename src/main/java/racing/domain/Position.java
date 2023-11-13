package racing.domain;

public class Position {
    private int value;

    public Position(int value) {
        validatePositionValue(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isFartherOrEqual(Position position) {
        return this.value >= position.value;
    }

    private void validatePositionValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 위치값으로 가질 수 없습니다.");
        }

    }

    public void move() {
        this.value++;
    }
}

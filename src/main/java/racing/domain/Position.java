package racing.domain;

public class Position {
    int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 위치값으로 가질 수 없습니다.");
        }
        this.value = value;
    }
}

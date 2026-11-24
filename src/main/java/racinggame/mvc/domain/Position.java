package racinggame.mvc.domain;

public final class Position {

    private int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public void advance() {
        value = Math.incrementExact(value);
    }

    public int getValue() {
        return value;
    }
}

package domain;

public class Position {
    private int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치 값은 음수가 올 수 없습니다");
        }
        this.value = value;
    }

    public void add(int moveStep) {
        this.value += moveStep;
    }

    public int maxComparedTo(int input) {
        return Math.max(this.value, input);
    }

    public Boolean isSame(int input) {
        return value == input;
    }
}

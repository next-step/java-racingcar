package racingcar.domain;

public class Position {
    private int position;

    // 주생성자
    public Position(int position) {
        throwIfNegative(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position increment() {
        position++;
        return new Position(position);
    }

    private static void throwIfNegative(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치값은 0보다 작을 수 없습니다.");
        }
    }
}

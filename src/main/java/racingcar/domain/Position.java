package racingcar.domain;

public class Position {
    private static final int MIN_POSITION = 0;

    private int position;

    public Position(int position) {
        if (position < MIN_POSITION) {
            throw new RuntimeException("유효한 자동차 위치 값이 아닙니다.");
        }
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }
}

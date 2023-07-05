package racingcar.domain;

public class Position {

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new RuntimeException("위치는 음수가 될 수 없습니다.");
        }
    }
}

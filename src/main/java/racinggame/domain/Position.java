package racinggame.domain;

public class Position {

    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수가 될수 없습니다");
        }
        this.position = position;
    }

    public Position move() {
        return new Position(position + 1);
    }

    public int getPosition() {
        return position;
    }
}

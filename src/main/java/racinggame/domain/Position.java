package racinggame.domain;

public class Position {

    private final int position;
    private final int POSITION_INCREMENT = 1;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수가 될수 없습니다");
        }
        this.position = position;
    }

    public Position add() {
        return new Position(position + POSITION_INCREMENT);
    }

    public int getPosition() {
        return position;
    }
}

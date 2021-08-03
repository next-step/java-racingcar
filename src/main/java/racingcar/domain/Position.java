package racingcar.domain;

public class Position {
    private int position;
    private static final int START_POSITION = 1;

    public Position() {
        this.position = START_POSITION;
    }

    private Position(int position) {
        this.position = position;
    }


    public int getPosition() {
        return position;
    }

    public Position move(Position position) {
        return new Position(position.position ++);
    }
}

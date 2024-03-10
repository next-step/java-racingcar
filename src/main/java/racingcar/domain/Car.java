package racingcar.domain;

public class Car {
    private int position = 0;

    public void move(MoveType moveType) {
        position += moveType.movePosition();
    }

    public int position() {
        return position;
    }
}

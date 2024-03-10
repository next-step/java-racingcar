package racingcar.domain;

public enum MoveType {
    FORWARD(1),
    STOP(0);

    private final int movePosition;

    MoveType(int movePosition) {
        this.movePosition = movePosition;
    }

    public int movePosition() {
        return this.movePosition;
    }
}

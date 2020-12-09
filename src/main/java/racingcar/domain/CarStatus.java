package racingcar.domain;

public enum CarStatus {
    MOVE,
    STOP;

    public boolean isMove() {
        return this == MOVE;
    }

    public boolean isStop() {
        return this == STOP;
    }
}

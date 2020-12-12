package racingcar.domain;

public class Car {
    private static final int MIN_CONDITION = 0;
    private static final int MAX_CONDITION = 9;
    private static final int MOVABLE_CONDITION = 4;
    private static final String OUT_OF_RANGE_CONDITION = "전진 조건 범위를 초과하였습니다.";

    private Position position = new Position();

    public Car() {}

    public void play(int condition) {
        validateMoveCondition(condition);
        if (isMove(condition)) {
            move();
        }
    }

    private void move() {
       this.position.add();
    }

    private void validateMoveCondition(int condition) {
        if (condition < MIN_CONDITION || condition > MAX_CONDITION) {
            throw new IllegalArgumentException(OUT_OF_RANGE_CONDITION);
        }
    }

    public int position() {
        return this.position.getPosition();
    }

    public boolean isMove(int condition) {
        return condition >= MOVABLE_CONDITION;
    }

    public boolean isMoved() {
        return this.position.isMoved();
    }

    public boolean isStop() {
        return this.position.isStop();
    }
}

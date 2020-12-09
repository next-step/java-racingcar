package racingcar.domain;

public class Car {
    private static final int MIN_CONDITION = 0;
    private static final int MAX_CONDITION = 9;
    private static final String OUT_OF_RANGE_CONDITION = "전진 조건 범위를 초과하였습니다.";
    private int position = 0;

    public Car() {
    }


    public CarStatus play(int condition) {
        validateMoveCondition(condition);
        if (matchCondition(condition)) {
            move();
            return CarStatus.MOVE;
        }

        return CarStatus.STOP;
    }

    private void move() {
        this.position++;
    }

    private void validateMoveCondition(int condition) {
        if (condition < MIN_CONDITION || condition > MAX_CONDITION) {
            throw new IllegalArgumentException(OUT_OF_RANGE_CONDITION);
        }
    }

    private boolean matchCondition(int condition) {
        return condition >= 4;
    }

}

package racingcar;

public class CarMoveCondition {

    private CarMoveCondition() {

    }

    public static boolean isMovable(int value) {
        return value >= 4;
    }

}

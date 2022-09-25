package racingcar.domain;

public class Car {
    public String positionView = "";
    private int criteriaNum = 4;

    public Car() {
    }

    public boolean isMoveAble(int randomInt) {
        if (randomInt >= criteriaNum) {
            return true;
        }
        return false;
    }

    public String moveCar(boolean isMoveable) {
        if (isMoveable == true) {
            positionView += "-";
        }
        return positionView;
    }
}

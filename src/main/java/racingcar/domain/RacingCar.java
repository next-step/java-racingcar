package racingcar.domain;

public class RacingCar {
    private static final int RANDOM_REFERENCE_VALUE = 4;
    private String carName;
    private MoveCounter moveCounter;

    public RacingCar(String carName) {
        this.carName = carName;
        this.moveCounter = new MoveCounter();
    }

    public RacingCar(String carName, int moveCount) {
        this.carName = carName;
        this.moveCounter = new MoveCounter(moveCount);
    }

    public int getMoveCount() {
        return moveCounter.getMoveCount();
    }

    public String getCarName() { return carName; }

    public void goOrStopRacing(int randomValue) {
        if (randomValue >= RANDOM_REFERENCE_VALUE) {
            moveCounter.move();
        }
    }

    public boolean isMoveCountEqualMaxCount(int maxCount) {
        return moveCounter.isMoveCountEqualMaxCount(maxCount);
    }


}

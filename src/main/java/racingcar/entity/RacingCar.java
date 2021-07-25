package racingcar.entity;


import racingcar.util.RandomNumberGenerator;

public class RacingCar {
    public static final int BASE_POSITION = 0;
    public static final int ONE_STEP = 1;
    public static final int SEPARATE_NUMBER = 4;
    private int position;

    public int getPosition() {
        return position;
    }

    public RacingCar() {
        this.position = BASE_POSITION;
    }

    public void moveIfMovable() {
        if (isMovable())
            position += ONE_STEP;
    }

    private boolean isMovable() {
        return RandomNumberGenerator.generate() >= SEPARATE_NUMBER;
    }

}

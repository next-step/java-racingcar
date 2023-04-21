package racingcar.domain;

public class CarMovingStrategy implements MovingStrategy{

    private final int CAR_MOVE_CRITERIA = 4;
    @Override
    public boolean movable() {
        return CAR_MOVE_CRITERIA >= RandomGenerator.getValue();
    }

}

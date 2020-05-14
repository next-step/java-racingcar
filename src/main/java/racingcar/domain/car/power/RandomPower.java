package racingcar.domain.car.power;

public class RandomPower implements Power {
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return RandomNumberGenerator.generate() >= MOVE_CONDITION;
    }
}

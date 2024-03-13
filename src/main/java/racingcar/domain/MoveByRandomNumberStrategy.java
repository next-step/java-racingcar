package racingcar.domain;

import racingcar.util.AbstractRandomNumber;
import racingcar.util.AbstractRandomNumberFactory;

public class MoveByRandomNumberStrategy implements MoveStrategy {

    public static final int MOVABLE_CAR_MIN_NUMBER = 4;

    private final AbstractRandomNumberFactory factory;

    public MoveByRandomNumberStrategy(AbstractRandomNumberFactory factory) {
        this.factory = factory;
    }

    @Override
    public Position move(Position position) {
        AbstractRandomNumber randomNumber = factory.produce();
        if (randomNumber.isMoreThan(MOVABLE_CAR_MIN_NUMBER)) {
            return position.moveOneStep();
        }
        return position;
    }

}

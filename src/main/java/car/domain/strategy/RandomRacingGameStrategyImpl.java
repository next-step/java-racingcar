package car.domain.strategy;

import car.domain.Car;
import car.domain.Cars;
import car.utils.RandomUtils;

import java.util.List;

public class RandomRacingGameStrategyImpl implements RacingGameStrategy {

    private static final int BOUNDARY_VALUE = 10;
    private static final int SATISFIED_VAL = 4;

    @Override
    public void apply(Cars cars) {
        List<Car> participants = cars.getParticipants();
        participants.forEach(this::checkCondition);
        cars.printPositionInfo();
    }

    private void checkCondition(Car car) {
        if (isSatisfied()) {
            car.move();
        }
    }

    @Override
    public boolean isSatisfied() {
        return SATISFIED_VAL <= RandomUtils.getRandomValueLesserThen(BOUNDARY_VALUE);
    }
}

package car.domain.condition;

import car.domain.Car;
import car.domain.Cars;
import car.ui.View;
import car.utils.RandomUtils;

import java.util.List;

public class RandomMovingStrategyImpl implements RacingGameStrategy {

    private static final int BOUNDARY_VALUE = 10;
    private static final int SATISFIED_VAL = 4;

    @Override
    public void apply(Cars cars) {
        List<Car> participants = cars.getParticipants();
        participants.forEach(this::checkCondition);
        System.out.println();
    }

    private void checkCondition(Car car) {
        if (isSatisfied()) {
            car.move();
        }
        View view = View.from(car);
        System.out.println(view.printStatus());
    }

    @Override
    public boolean isSatisfied() {
        return SATISFIED_VAL <= RandomUtils.getRandomValueLesserThen(BOUNDARY_VALUE);
    }
}

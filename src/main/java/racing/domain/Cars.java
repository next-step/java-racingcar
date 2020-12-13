package racing.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

import static racing.common.Verify.checkArgument;

public class Cars {

    public static final String CAR_NAME_DELIMITER = ",";

    private static final String INVALID_INPUT_MESSAGE = "input cannot be null or empty";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String input) {
        checkArgument(StringUtils.isNotBlank(input), INVALID_INPUT_MESSAGE);

        String[] carNames = input.split(CAR_NAME_DELIMITER);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public int size() {
        return cars.size();
    }

    public void moveAll(MoveStrategy strategy) {
        for (Car car : cars) {
            tryMove(car, strategy);
        }
    }

    public void iterateCar(IntConsumer distanceConsumer) {
        for (Car car : cars) {
            distanceConsumer.accept(car.getMovedDistance());
        }
    }

    private void tryMove(Car car, MoveStrategy strategy) {
        if (strategy.movable()) {
            car.move();
        }
    }
}

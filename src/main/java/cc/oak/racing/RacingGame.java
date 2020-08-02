package cc.oak.racing;

import cc.oak.racing.condition.CarForwardCondition;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final CarForwardCondition<?> carForwardCondition;

    public RacingGame(CarForwardCondition<?> carForwardCondition) {
        if (carForwardCondition == null) {
            throw new IllegalArgumentException("carForwardCondition is null!");
        }
        this.carForwardCondition = carForwardCondition;
    }

    public RacingRound createRound(int totalCarCount, int totalRoundCount) {
        validateCreateRoundArguments(totalCarCount, totalRoundCount);

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < totalCarCount; i++) {
            cars.add(createCar());
        }
        return new RacingRound(cars, totalRoundCount);
    }

    private void validateCreateRoundArguments(int totalCarCount, int totalRoundCount) {
        if (totalCarCount < 0) {
            throw new IllegalArgumentException("totalCarCount should be greater than 0.");
        }

        if (totalRoundCount < 0) {
            throw new IllegalArgumentException("totalRoundCount should be greater than 0.");
        }
    }

    private Car createCar() {
        return new Car(carForwardCondition);
    }
}

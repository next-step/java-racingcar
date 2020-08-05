package cc.oakk.racing;

import cc.oakk.racing.predicate.CarForwardCondition;

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

    public RacingRound createRound(List<String> carNames, int totalRoundCount) {
        validateCreateRoundArguments(carNames, totalRoundCount);

        List<Car> cars = new ArrayList<>();
        carNames.forEach(name -> cars.add(createCar(name)));
        return new RacingRound(cars, totalRoundCount);
    }

    private void validateCreateRoundArguments(List<String> carNames, int totalRoundCount) {
        if (carNames == null) {
            throw new IllegalArgumentException("carNames is null.");
        }

        if (carNames.size() <= 0) {
            throw new IllegalArgumentException("totalCarCount should be greater than 0.");
        }

        if (totalRoundCount <= 0) {
            throw new IllegalArgumentException("totalRoundCount should be greater than 0.");
        }
    }

    private Car createCar(String name) {
        return new Car(name, carForwardCondition);
    }
}

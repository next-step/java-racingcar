package cc.oakk.racing.domain;

import cc.oakk.racing.domain.predicate.CarForwardCondition;
import cc.oakk.racing.util.Validator;

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
        Validator.checkList(carNames);
        Validator.checkGreaterThanZero(totalRoundCount);
    }

    private Car createCar(String name) {
        return new Car(name, carForwardCondition);
    }
}

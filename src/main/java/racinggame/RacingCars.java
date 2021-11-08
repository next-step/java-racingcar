package racinggame;

import racinggame.utils.MoveValueGenerator;
import racinggame.utils.MoveValueValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;
    private final List<MoveResult> moveResults;

    public RacingCars(List<Car> cars) {
        this(cars, new ArrayList<>());
    }

    private RacingCars(List<Car> cars, List<MoveResult> moveResults) {
        this.cars = cars;
        this.moveResults = moveResults;
    }

    public RacingCars move(int attempts) {
        if (moveResults.size() != 0) {
            return new RacingCars(cars).move(attempts);
        }

        for (int i = 0; i < attempts; i++) {
            cars.forEach(car -> car.move(
                    MoveValueValidator.validate(
                            MoveValueGenerator.generateMoveValue())));

            moveResults.add(getMoveResults());
        }

        return new RacingCars(cars, moveResults);
    }

    public List<MoveResult> getRacingResult() {
        return this.moveResults;
    }

    private MoveResult getMoveResults() {
        return new MoveResult(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));
    }
}

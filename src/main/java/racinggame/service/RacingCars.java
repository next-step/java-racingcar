package racinggame.service;

import racinggame.domain.Car;
import racinggame.utils.MoveValueGenerator;
import racinggame.domain.value.MoveResult;
import racinggame.domain.value.RacingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> cars;
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
            cars = cars.stream()
                    .map(car -> car.move(MoveValueGenerator.generateMoveValue()))
                    .collect(Collectors.toList());
            moveResults.add(getMoveResults());
        }

        return new RacingCars(cars, moveResults);
    }

    public RacingResult getRacingResult() {
        return new RacingResult(moveResults);
    }

    private MoveResult getMoveResults() {
        return new MoveResult(cars);
    }
}

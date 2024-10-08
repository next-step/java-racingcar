package race.domain;

import race.model.RaceRecord;
import race.model.RaceResult;
import race.model.CarName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        this.racingCars = List.copyOf(racingCars);
        this.moveStrategy = moveStrategy;
    }

    public RaceResult race() {
        for (RacingCar car : racingCars) {
            car.moveForward(moveStrategy);
        }

        return getRacingCarsPosition(racingCars);
    }

    private RaceResult getRacingCarsPosition(List<RacingCar> racingCars) {
        List<RaceRecord> result = new ArrayList<>();
        for (RacingCar car : racingCars) {
            result.add(RaceRecord.from(car));
        }
        return new RaceResult(result);
    }

    public List<CarName> findWinnersName() {
        int largestMovement = findLargestMovement();

        return racingCars.stream()
                .filter(car -> car.hasSamePosition(largestMovement))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int findLargestMovement() {
        int maxValue = 0;
        for (RacingCar racingCar : racingCars) {
            maxValue = racingCar.findMaxValue(maxValue);
        }

        return maxValue;
    }

}

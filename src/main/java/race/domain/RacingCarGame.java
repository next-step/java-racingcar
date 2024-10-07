package race.domain;

import race.util.NumberPicker;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final static int RANDOM_NUMBER_LIMIT = 10;
    private final NumberPicker numberPicker = new NumberPicker();

    public RacingCarGame(List<RacingCar> racingCars) {
        this.racingCars = List.copyOf(racingCars);
    }

    public List<RacingCar> race() {
        for (RacingCar car : racingCars) {
            car.moveForward(new MoveStrategy(), numberPicker.generateRandomNumber(RANDOM_NUMBER_LIMIT));
        }

        return racingCars;
    }

    public List<RacingCar> findWinners() {
        int largestMovement = findLargestMovement();

        return racingCars.stream()
                .filter(car -> car.hasSamePosition(largestMovement))
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

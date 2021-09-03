package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    public final List<RacingCar> racingCars;

    public RacingCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            RacingCar racingCar = new RacingCar();
            cars.add(racingCar);
        }
        this.racingCars = cars;
    }

    public void racingAttempt() {
        racingCars.forEach(racingCar -> {
            int randomNumber = RandomGenerator.randomNumber();
            racingCar.moveOrStop(randomNumber);
        });
    }

    public List<Integer> getResultAttempt() {
        return racingCars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }
}

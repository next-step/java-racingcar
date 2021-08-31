package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    public final List<RacingCar> cars;

    public RacingCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            RacingCar car = new RacingCar();
            cars.add(car);
        }
        this.cars = cars;
    }

    public void racingAttempt() {
        cars.forEach(car -> {
            int randomNumber = RandomUtils.randomNumber();
            car.moveOrStop(randomNumber);
        });
    }

    public List<Integer> getResultAttempt() {
        return cars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }
}

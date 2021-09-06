package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    public final List<RacingCar> racingCars;

    public RacingCars(String[] names) {
        this.racingCars = Arrays.stream(names)
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public void racingAttempt() {
        racingCars.forEach(racingCar -> {
            int randomNumber = RandomGenerator.randomNumber();
            racingCar.moveOrStop(randomNumber);
        });
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

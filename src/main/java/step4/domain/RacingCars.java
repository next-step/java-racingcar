package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(int numberOfCars) {
        racingCars = IntStream.rangeClosed(1, numberOfCars)
                .mapToObj(RacingCar::new)
                .collect(Collectors.toList());
    }

    public RacingCars(String[] cars) {
        racingCars = IntStream.range(0, cars.length)
                .mapToObj(i -> new RacingCar(i + 1, cars[i]))
                .collect(Collectors.toList());
    }

    public List<RacingCar> list() {
        return this.racingCars;
    }

    public void raceCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.list()) racingCar.raceCar();
    }

    public RacingCar winner() {
        return racingCars.stream().max(RacingCar::compareTo).get();
    }
}

package step5.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<String> winners() {
        RacingCar winner = racingCars.stream().max(RacingCar::compareTo).orElseThrow(NoSuchElementException::new);
        return racingCars.stream().filter(racingCar -> racingCar.position() == winner.position()).map(RacingCar::name).collect(Collectors.toList());
    }
}

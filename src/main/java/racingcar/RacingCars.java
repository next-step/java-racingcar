package racingcar;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race(CarMover carMover, int attemptNumber) {
        racingCars.forEach(racingCar -> racingCar.race(attemptNumber, carMover));
    }

    public RaceRecords getRaceRecords() {
        return racingCars.stream()
                .map(RacingVehicle::getRaceRecord)
                .collect(collectingAndThen(toList(), RaceRecords::new));
    }
}

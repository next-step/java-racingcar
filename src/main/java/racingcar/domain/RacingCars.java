package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void race(CarMover carMover, int attemptNumber) {
        racingCars.forEach(racingCar -> racingCar.race(attemptNumber, carMover));
    }

    public List<RaceRecord> getRaceRecords() {
        return racingCars.stream()
                .map(RacingVehicle::getRaceRecord)
                .collect(Collectors.toList());
    }
}

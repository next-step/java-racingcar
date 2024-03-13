package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(int numberOfCars) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) racingCars.add(new RacingCar(i));
    }

    public RacingCars(String[] cars) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) racingCars.add(new RacingCar(i, cars[i]));
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

package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(int numberOfCars) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) racingCars.add(new RacingCar(i));

    }

    public List<RacingCar> list() {
        return this.racingCars;
    }

    public void raceCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.list()) racingCar.raceCar();
    }
}

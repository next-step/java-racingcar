package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(Integer carNumbers) {
        List<Car> racingCars = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++) {
            racingCars.add(new Car(new CarMoving()));
        }
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

}

package model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars = null;

    public RacingCars() {
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getValue() {
        return racingCars;
    }

    public static RacingCars create(int count) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            racingCars.add(new RacingCar());
        }

        return new RacingCars(racingCars);
    }

    public void move() {
        for (RacingCar racingCar : this.getValue()) {
            racingCar.move();
        }
    }
}

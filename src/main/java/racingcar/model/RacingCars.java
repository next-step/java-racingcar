package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
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

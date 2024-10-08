package javaracingcarwinner.entity;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final List<RacingCar> roundCars = new ArrayList<>();
    private final Move move = new Move();

    public Round(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.move(this.move);
            this.roundCars.add(car.currentLocationSave());
        }
    }

    public List<RacingCar> getRoundCars() {
        return roundCars;
    }
}

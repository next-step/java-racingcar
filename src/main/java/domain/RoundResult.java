package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    List<Integer> carPositions;

    public RoundResult(List<RacingCar> cars) {
        this.carPositions = new ArrayList<>();
        for (RacingCar car : cars) {
            carPositions.add(car.whereIsCar());
        }
    }

    public List<Integer> whereAreCars() {
        return this.carPositions;
    }
}

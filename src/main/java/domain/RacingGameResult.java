package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<RacingCar> racedCars;

    public RacingGameResult(List<RacingCar> racedCars) {
        this.racedCars = new ArrayList<>(racedCars);
    }

    public List<RacingCar> getRacedCars() {
        return this.racedCars;
    }
}

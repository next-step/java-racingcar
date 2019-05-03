package racing;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public int count() {
        return racingCars.size();
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<RacingCar> getObject() {
        return racingCars;
    }
}

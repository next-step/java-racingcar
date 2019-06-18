package carRacing.model;

import java.util.List;

public class RacingCarGroup {

    private List<Car> racingCars;

    public RacingCarGroup(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}

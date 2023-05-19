package study.racingcar;

import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCarsList) {
        this.racingCars = racingCarsList;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

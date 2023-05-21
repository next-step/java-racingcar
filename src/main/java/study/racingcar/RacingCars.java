package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars() {
    }

    public RacingCars(List<RacingCar> racingCarsList) {
        this.racingCars = racingCarsList;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void settingRacingCars(String[] carNames) {
        for (String carName : carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
    }
}

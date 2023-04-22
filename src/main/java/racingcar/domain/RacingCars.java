package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        List<RacingCar> originCars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            originCars.add(new RacingCar(carNames[i]));
        }

        this.racingCars = new ArrayList<>(originCars);
    }

    public RacingCars(List<RacingCar> carList) {
        this.racingCars = new ArrayList<>(carList);
    }

    public List<RacingCar> statusOfRacingCars() {
        return new ArrayList<>(racingCars);
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCreator {
    private List<RacingCar> racingCars;

    public RacingCars player(String[] carNames) {
        racingCars = new ArrayList<>();
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
        return new RacingCars(racingCars);
    }
}

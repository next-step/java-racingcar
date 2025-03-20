package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    public static List<RacingCar> createRacingCars(String[] carNames, RacingCarMoveStrategy moveStrategy) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(new RacingCar(new RacingCarName(carName), moveStrategy));
        }

        return racingCars;
    }

}

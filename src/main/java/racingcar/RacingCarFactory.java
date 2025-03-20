package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    public static List<RacingCar> createRacingCars(String[] carNames, RacingCarMoveStrategy moveStrategy) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            racingCars.add(create(carName, moveStrategy));
        }

        return racingCars;
    }

    public static RacingCar create(String carName, RacingCarMoveStrategy moveStrategy) {
        return new RacingCar(new RacingCarName(carName), moveStrategy);
    }

}

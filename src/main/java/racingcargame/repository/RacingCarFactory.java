package racingcargame.repository;

import racingcargame.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    public static List<RacingCar> makeCars(int carCount) {
        List<RacingCar> racingCars = new ArrayList<>();
        while (carCount-- > 0) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

}

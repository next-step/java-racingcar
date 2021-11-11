package racingcargame.repository;

import racingcargame.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarRepository {

    private List<RacingCar> racingCars;

    public RacingCarRepository(int carCount) {
        racingCars = new ArrayList<>();
        while (carCount-- > 0) {
            racingCars.add(new RacingCar());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

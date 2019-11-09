package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Cars> racingCars;
    private Cars cars;
    public RacingGame(Cars cars) {
        this.racingCars = new ArrayList<>();
        this.cars = cars;
    }

    public List<Cars> racingGame() {
        racingCars.add(cars.moveCarsPositionByInterface());
        return racingCars;
    }

}

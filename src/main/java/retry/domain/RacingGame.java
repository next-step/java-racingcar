package retry.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Cars> racingCars;
    private Cars cars;
    public RacingGame(Cars cars) {
        this.racingCars = new ArrayList<>();
        this.cars = cars;
    }

    public List<Cars> execute(int time) {
        for (int i = 0; i < time; i++) {
            racingGame();
        }
        return racingCars;
    }

    public List<Cars> racingGame() {
        Cars movedCars = cars.moveCarsPositionByInterface();
        racingCars.add(movedCars);
        this.cars = movedCars;
        return racingCars;
    }
}

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

    public RacingGame(Cars cars, int time) {
        this.racingCars = new ArrayList<>();
        this.cars = cars;
    }

    public void execute(int time) {
        for (int i = 0; i < time; i++) {
            racingGame();
        }
    }

    public List<Cars> racingGame() {
        racingCars.add(cars.moveCarsPositionByInterface());
        return racingCars;
    }

    public List<Cars> getRacingCars() {
        return racingCars;
    }
}

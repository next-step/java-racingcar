package retry.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_POSITION_VALUE = 0;
    private List<Cars> racingCars;
    private Cars cars;

    public RacingGame(Cars cars) {
        this.racingCars = new ArrayList<>();
        this.cars = cars;
    }

    public List<Cars> execute(int time) {
        for (int i = 0; i < time; i++) {
            repeatRacingGame();
        }
        return racingCars;
    }

    public List<Cars> repeatRacingGame() {
        Cars movedCars = cars.moveCarsPositionByInterface();
        racingCars.add(movedCars);
        this.cars = movedCars;
        return racingCars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPositionValue();
        return this.cars.getWinnerCars(winnerPosition);
    }

    private int getWinnerPositionValue() {
        int maxPositionValue = MAX_POSITION_VALUE;
        for (Cars racingCar : this.racingCars) {
            maxPositionValue = racingCar.getWinnerPositionValue(maxPositionValue);
        }
        return maxPositionValue;
    }
}

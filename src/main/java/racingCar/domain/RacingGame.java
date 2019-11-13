package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_POSITION_VALUE = 0;
    private final List<Cars> allTimeLapRacingCars;
    private Cars currentRacingCars;

    public RacingGame(Cars cars) {
        this.allTimeLapRacingCars = new ArrayList<>();
        this.currentRacingCars = cars;
    }

    public List<Cars> execute(int time) {
        for (int i = 0; i < time; i++) {
            repeatRacingGame();
        }
        return allTimeLapRacingCars;
    }

    public List<Cars> repeatRacingGame() {
        Cars movedCars = currentRacingCars.move();
        allTimeLapRacingCars.add(movedCars);
        this.currentRacingCars = movedCars;
        return allTimeLapRacingCars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPositionValue();
        return this.currentRacingCars.getWinnerCars(winnerPosition);
    }

    private int getWinnerPositionValue() {
        int maxPositionValue = MAX_POSITION_VALUE;
        for (Cars racingCar : this.allTimeLapRacingCars) {
            maxPositionValue = racingCar.getWinnerPositionValue(maxPositionValue);
        }
        return maxPositionValue;
    }
}

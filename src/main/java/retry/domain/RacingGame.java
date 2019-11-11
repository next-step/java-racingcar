package retry.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_POSITION_VALUE = 0;
    private final List<Cars> AllTimeLapRacingCars;
    private Cars CurrentRacingCars;

    public RacingGame(Cars cars) {
        this.AllTimeLapRacingCars = new ArrayList<>();
        this.CurrentRacingCars = cars;
    }

    public List<Cars> execute(int time) {
        for (int i = 0; i < time; i++) {
            repeatRacingGame();
        }
        return AllTimeLapRacingCars;
    }

    public List<Cars> repeatRacingGame() {
        Cars movedCars = CurrentRacingCars.moveCarWhenRandomNumberBetterThanPivotNumber();
        AllTimeLapRacingCars.add(movedCars);
        this.CurrentRacingCars = movedCars;
        return AllTimeLapRacingCars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPositionValue();
        return this.CurrentRacingCars.getWinnerCars(winnerPosition);
    }

    private int getWinnerPositionValue() {
        int maxPositionValue = MAX_POSITION_VALUE;
        for (Cars racingCar : this.AllTimeLapRacingCars) {
            maxPositionValue = racingCar.getWinnerPositionValue(maxPositionValue);
        }
        return maxPositionValue;
    }
}

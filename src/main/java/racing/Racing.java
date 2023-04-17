
package racing;

import java.util.List;

public class Racing {
    private int leftMatchCounts;

    private RacingCars racingCars;

    public Racing(int matchCounts, List<Car> cars) {
        this.leftMatchCounts = matchCounts;
        readyRacingCars(cars);
    }

    public RacingCars race() {
        this.racingCars.moveCars();
        finishMatch();

        return this.racingCars;
    }

    private void readyRacingCars(List<Car> cars) {
        this.racingCars = RacingCars.create(cars);
    }

    private void finishMatch() {
        this.leftMatchCounts--;
    }

    public int getLeftMatchCounts() {
        return leftMatchCounts;
    }
}

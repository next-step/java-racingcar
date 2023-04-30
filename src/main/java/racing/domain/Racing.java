
package racing.domain;

import java.util.List;

public class Racing {
    private MatchCount leftMatchCount;
    private RacingCars racingCars;

    public Racing(int matchCounts, List<Car> cars) {
        this.leftMatchCount = new MatchCount(matchCounts);
        readyRacingCars(cars);
    }

    public RacingCars race() {
        this.racingCars.moveCars();
        finishMatch();

        return this.racingCars;
    }

    public void finishMatch() {
        this.leftMatchCount = this.leftMatchCount.decrease();
    }

    public MatchCount getLeftMatchCount() {
        return this.leftMatchCount.getMatchCount();
    }

    public boolean isNotFinished() {
        return !this.leftMatchCount.isZero();
    }

    private void readyRacingCars(List<Car> cars) {
        this.racingCars = RacingCars.create(cars);
    }

}

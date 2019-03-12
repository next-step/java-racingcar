package racingcar.domain;

import racingcar.vo.RacingGameRound;

import java.util.Collections;
import java.util.List;

public class RacingGameInfo {
    private List<Car> cars;
    private RacingGameRound racingGameRound;

    public RacingGameInfo(List<Car> cars, RacingGameRound racingGameRound) {
        this.cars = cars;
        this.racingGameRound = racingGameRound;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public RacingGameRound getRacingGameRound() {
        return racingGameRound;
    }

    public boolean hasNextRound() {
        int totalRound = this.racingGameRound.getTotalRound();
        int currentRound = this.racingGameRound.getCurrentRound();

        return currentRound <= totalRound;
    }

    public void incrementCurrentRound() {
        int currentRound = this.racingGameRound.getCurrentRound();
        setCurrentRound(currentRound + 1);
    }

    public void initializeCurrentRound() {
        setCurrentRound(0);
    }

    private void setCurrentRound(int currentRound) {
        int totalRound = this.racingGameRound.getTotalRound();
        this.racingGameRound = new RacingGameRound(totalRound, currentRound);
    }
}

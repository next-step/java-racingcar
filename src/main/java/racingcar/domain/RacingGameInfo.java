package racingcar.domain;

import racingcar.vo.RacingGameRound;

import java.util.List;

public class RacingGameInfo {
    private static final int FIRST_ROUND = 1;

    private RacingCarGroup racingCarGroup;
    private RacingGameRound racingGameRound;

    public RacingGameInfo(RacingCarGroup racingCarGroup, RacingGameRound racingGameRound) {
        this.racingCarGroup = racingCarGroup;
        this.racingGameRound = racingGameRound;
    }

    public List<Car> getCars() {
        return this.racingCarGroup.getCars();
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

    public void initialize() {
        this.racingCarGroup.initialize();
        setCurrentRound(FIRST_ROUND);
    }

    private void setCurrentRound(int currentRound) {
        int totalRound = this.racingGameRound.getTotalRound();
        this.racingGameRound = new RacingGameRound(totalRound, currentRound);
    }

    public void moveCars() {
        this.racingCarGroup.go();
    }
}

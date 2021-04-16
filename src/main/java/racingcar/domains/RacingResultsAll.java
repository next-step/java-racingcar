package racingcar.domains;

import java.util.List;

public class RacingResultsAll {

    private List<RacingResultsPerRound> racingResultAllRounds;

    public RacingResultsAll(List<RacingResultsPerRound> racingResultAllRounds) {
        this.racingResultAllRounds = racingResultAllRounds;
    }

    public int size() {
        return racingResultAllRounds.size();
    }

    public RacingResultsPerRound getRacingResultsPerRound (int roundNum) {
        return racingResultAllRounds.get(roundNum);
    }

}

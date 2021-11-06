package racingcar.controller.model;

import racingcar.utils.Preconditions;

import java.util.List;

public class RacingCarOutput {
    private final String winnerName;
    private final List<RaceResult> raceResults;

    public RacingCarOutput(String winnerName, List<RaceResult> raceResults) {
        Preconditions.checkNotNull(winnerName, "winnerName는 필수값입니다.");
        Preconditions.checkNotNull(raceResults, "raceResults는 필수값입니다.");

        this.winnerName = winnerName;
        this.raceResults = raceResults;
    }

    public static RacingCarOutput of(String winnerName, List<RaceResult> raceResults) {
        return new RacingCarOutput(winnerName, raceResults);
    }

    public String getWinnerName() {
        return winnerName;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }
}

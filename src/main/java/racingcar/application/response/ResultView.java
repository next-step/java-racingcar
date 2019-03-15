package racingcar.application.response;

public class ResultView {
    private final RacingViews raceProgress;
    private final WinnerViews winners;

    public ResultView(final RacingViews raceProgress, final WinnerViews winners) {
        this.raceProgress = raceProgress;
        this.winners = winners;
    }

    public RacingViews getRaceProgress() {
        return raceProgress;
    }

    public WinnerViews getWinners() {
        return winners;
    }
}

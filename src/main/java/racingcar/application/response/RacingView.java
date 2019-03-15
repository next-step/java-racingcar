package racingcar.application.response;

public class RacingView {
    private final int time;
    private final RacingCarViews racingCarViews;

    public RacingView(final int time, final RacingCarViews racingCarViews) {
        this.time = time;
        this.racingCarViews = racingCarViews;
    }

    public int getTime() {
        return time;
    }

    public RacingCarViews getRacingCarViews() {
        return racingCarViews;
    }
}

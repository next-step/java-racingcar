package racingcar.application;

public class ResultView {
    private final int time;
    private final RacingCarViews views;

    public ResultView(final int time, final RacingCarViews views) {
        this.time = time;
        this.views = views;
    }

    public int getTime() {
        return time;
    }

    public RacingCarViews getViews() {
        return views;
    }
}

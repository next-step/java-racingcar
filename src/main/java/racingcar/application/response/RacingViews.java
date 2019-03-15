package racingcar.application.response;

import java.util.ArrayList;
import java.util.List;

public class RacingViews {
    private final List<RacingView> views;

    public RacingViews(final List<RacingView> views) {
        this.views = new ArrayList<>(views);
    }

    public List<RacingView> get() {
        return new ArrayList<>(views);
    }
}

package racingcar.application;

import java.util.ArrayList;
import java.util.List;

public class RacingCarViews {
    private final List<RacingCarView> views;

    public RacingCarViews(final List<RacingCarView> views) {
        this.views = new ArrayList<>(views);
    }

    public List<RacingCarView> get() {
        return new ArrayList<>(views);
    }
}

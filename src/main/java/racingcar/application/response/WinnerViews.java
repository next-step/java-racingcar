package racingcar.application.response;

import java.util.ArrayList;
import java.util.List;

public class WinnerViews {
    private final List<String> views;

    public WinnerViews(final List<String> views) {
        this.views = new ArrayList<>(views);
    }

    public List<String> get() {
        return new ArrayList<>(views);
    }
}

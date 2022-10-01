package racingcar.view;

import racingcar.domain.Watcher;

public class GameOutputView {
    private final Watcher watcher;

    public GameOutputView(Display displayer) {
        watcher = new Watcher(distances -> { displayer.show(distances); });
    }

    public Watcher watcher() {
        return watcher;
    }
}



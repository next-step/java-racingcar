package racingcar.view;

import racingcar.domain.Watcher;

public class GameOutputView {
    private final Watcher watcher;

    public GameOutputView(Watcher watcher) {
        this.watcher = watcher;
    }

    public Watcher watcher() {
        return watcher;
    }
}



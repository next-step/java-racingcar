package racingcar.domain;

import java.util.List;

import racingcar.view.Display;

public class Watcher {
    private final Display displayer;

    public Watcher(Display displayer) {
        this.displayer = displayer;
    }

    public void notify(Distances distancese) {
        displayer.show(distancese);
    }

    public void notifyFinish(Distances distances) {
        displayer.showWinners(distances);
    }
}

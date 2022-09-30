package racingcar.view;

import java.util.List;

import racingcar.domain.Distance;

public class Watcher {
    private final Display display;

    public Watcher(Display display) {
        this.display = display;
    }

    public void notify(List<Distance> distance) {
        display.show(distance);
    }
}



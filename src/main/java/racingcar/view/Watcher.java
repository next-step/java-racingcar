package racingcar.view;

import java.util.List;
import java.util.function.Consumer;

import racingcar.domain.Distance;

public class Watcher {
    private final Consumer<List<Distance>> display;

    public Watcher(Consumer<List<Distance>> display) {
        this.display = display;
    }

    public void notify(List<Distance> distance) {
        display.accept(distance);
    }
}

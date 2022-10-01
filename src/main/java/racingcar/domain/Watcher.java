package racingcar.domain;

import java.util.List;
import java.util.function.Consumer;

public class Watcher {
    private final Consumer<List<Distance>> action;

    public Watcher(Consumer<List<Distance>> action) {
        this.action = action;
    }
    
    public void notify(List<Distance> distance) {
        action.accept(distance);
    }
}

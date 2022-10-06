package racing_game.domain;

import java.util.Collections;
import java.util.List;
import racing_game.core.Positive;

public class Distances {

    private final List<Positive> holder;

    private Distances(List<Positive> distances) {
        this.holder = distances;
    }

    public static Distances create(List<Positive> distances) {
        return new Distances(distances);
    }

    public List<Positive> toPositives() {
        return Collections.unmodifiableList(holder);
    }
}

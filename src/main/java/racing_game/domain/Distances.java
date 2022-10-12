package racing_game.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing_game.core.Positive;

public class Distances {

    private final List<Positive> holder;

    public Distances(Cars cars) {
        this.holder = cars.toList()
            .stream()
            .map(Car::getDistance)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Positive> get() {
        return Collections.unmodifiableList(holder);
    }

}

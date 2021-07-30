package carracing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Positions {

    private final List<Position> positions;

    private Positions(List<Position> positions) {
        this.positions = Collections.unmodifiableList(Objects.requireNonNull(positions));
    }

    public static Positions of(List<Position> positions) {
        return new Positions(positions);
    }

    public void forEach(Consumer<Position> action) {
        positions.forEach(action);
    }
}

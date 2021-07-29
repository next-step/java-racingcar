package carracing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Positions implements Renderer {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private final List<Position> positions;

    private Positions(List<Position> positions) {
        this.positions = Collections.unmodifiableList(Objects.requireNonNull(positions));
    }

    public static Positions of(List<Position> positions) {
        return new Positions(positions);
    }

    @Override
    public String render() {
        return positions.stream()
                .map(position -> position.render())
                .collect(Collectors.joining(NEW_LINE));
    }
}

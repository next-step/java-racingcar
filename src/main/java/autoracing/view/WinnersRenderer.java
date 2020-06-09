package autoracing.view;

import autoracing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersRenderer {
    private static final String DEFAULT_DELIMITER = ", ";

    private CharSequence delimiter;

    public WinnersRenderer(CharSequence delimiter) {
        this.delimiter = delimiter;
    }

    public WinnersRenderer() {
        this(DEFAULT_DELIMITER);
    }

    public String render(List<Car> winners) {
        return winners.stream().map(Car::getName).collect(Collectors.joining(delimiter));
    }
}

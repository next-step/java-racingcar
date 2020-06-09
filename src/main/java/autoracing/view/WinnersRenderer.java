package autoracing.view;

import autoracing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersRenderer {
    private static final String DEFAULT_DELIMITER = ", ";

    private List<Car> winners;
    private CharSequence delimiter;

    public WinnersRenderer(List<Car> winners, CharSequence delimiter) {
        this.winners = winners;
        this.delimiter = delimiter;
    }

    public WinnersRenderer(List<Car> winners) {
        this(winners, DEFAULT_DELIMITER);
    }

    public String render() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(delimiter));
    }
}

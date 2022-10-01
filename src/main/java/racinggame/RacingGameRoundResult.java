package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameRoundResult {

    private static final String DISTANCE_SYMBOL = "-";

    private final List<Car> cars;

    public RacingGameRoundResult() {
        this.cars = new ArrayList<>();
    }

    public RacingGameRoundResult(List<Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public String getContent() {
        return cars.stream()
                .map(this::getContentFormat)
                .collect(Collectors.joining(StringConstants.NEW_LINE));
    }

    private String getContentFormat(Car car) {
        return String.format("%s : %s", car.getName(), DISTANCE_SYMBOL.repeat(car.getPosition()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameRoundResult that = (RacingGameRoundResult) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}

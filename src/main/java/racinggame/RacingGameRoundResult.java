package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameRoundResult {

    private static final String DISTANCE_SYMBOL = "-";
    private static final int MIN_VALUE_OF_POSITION = 0;

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
                .collect(Collectors.joining());
    }

    private String getContentFormat(Car car) {
        return String.format("%s : %s" + StringConstants.NEW_LINE, car.getName(), DISTANCE_SYMBOL.repeat(car.getPosition()));
    }

    public List<String> getFarthestCarNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_VALUE_OF_POSITION);
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

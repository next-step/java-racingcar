package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> value;

    public Cars(List<Car> value) {
        this.value = new ArrayList<>(value);
    }

    public List<Car> getValue() {

        return Collections.unmodifiableList(value);
    }

    public List<String> getCarNames() {
        return value.stream().map(car -> car.getName().getValue())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(value, cars.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public List<String> filterWinners() {
        int winnerPosition = getWinnerPosition();
        return getWinnerNames(winnerPosition);
    }


    private List<String> getWinnerNames(int winnerPosition) {
        return value.stream()
                .filter(car -> car.getPosition().isEquals(winnerPosition))
                .map(car -> car.getName().getValue())
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return value.stream()
                .mapToInt(car -> car.getPosition().getValue())
                .max()
                .orElseThrow(() -> new IllegalArgumentException("The winner is not exists."));
    }
}

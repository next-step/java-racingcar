package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameRoundResult {

    private static final int MIN_VALUE_OF_POSITION = 0;

    private final List<RacingGameCarResult> cars;

    public RacingGameRoundResult() {
        this(new ArrayList<>());
    }

    public RacingGameRoundResult(List<RacingGameCarResult> cars) {
        this.cars = cars;
    }

    public void add(RacingGameCarResult car) {
        cars.add(car);
    }

    public List<CarName> getFarthestCarNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingGameCarResult::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(RacingGameCarResult::getPosition)
                .max()
                .orElse(MIN_VALUE_OF_POSITION);
    }

    public List<RacingGameCarResult> getCars() {
        return cars;
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

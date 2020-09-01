package racing.core.domain;

import racing.core.exception.ErrorMessage;
import racing.core.patterns.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public final class Cars {

    private static final int WINNER = 0;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateList(cars);
        this.cars = cars;
    }

    private void validateList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CARS.getMessage());
        }
    }

    public Cars runTrial(MoveStrategy movement) {
        List<Car> after = new ArrayList<>();
        for (Car car : cars) {
            after.add(car.move(movement));
        }
        return new Cars(after);
    }

    public List<Car> getWinners() {
        List<Car> orderedCars = getCarsOrderedByPositionDesc();
        return orderedCars.stream()
                .filter(car -> orderedCars.get(WINNER).isSamePosition(car))
                .collect(Collectors.toList());
    }

    private List<Car> getCarsOrderedByPositionDesc() {
        List<Car> copy = new ArrayList<>(cars);
        Collections.sort(copy);
        return copy;
    }

    public static Cars of(String[] namesOfCars) {
        List<Car> participants = Arrays.stream(namesOfCars)
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(participants);
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

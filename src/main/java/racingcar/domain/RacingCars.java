package racingcar.domain;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingCars implements Iterable<RacingCar> {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCars getFarthestRacingCars() {
        List<Position> positions = cars.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());

        Position maxPosition = Collections.max(positions);

        List<RacingCar> farthestRacingCars = cars.stream()
                .filter((car) -> car.isInPosition(maxPosition))
                .collect(Collectors.toList());

        return new RacingCars(farthestRacingCars);
    }

    public RacingCar get(int index) {
        return cars.get(index);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(RacingCar::getName)
                .map(RacingCarName::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return cars.iterator();
    }

    @Override
    public void forEach(Consumer<? super RacingCar> action) {
        cars.forEach(action);
    }

    @Override
    public Spliterator<RacingCar> spliterator() {
        return cars.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}

package racingcar.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
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
                .filter((car) -> car.getPosition().equals(maxPosition))
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
    public boolean equals(Object obj) {
        return cars.equals(((RacingCars)obj).cars);
    }
}

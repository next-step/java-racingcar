package racing.domain.car;

import racing.domain.fuel.Fuel;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final Set<Car> values;

    public Cars(Set<Car> values) {
        this.values = values;
    }

    public Optional<Car> findWinner() {
        return values.stream()
                .max(Car::compareLocation);
    }

    public Cars findWinners() {
        Car winner = findWinner().orElseThrow(EmptyCarException::new);

        return new Cars(this.values.stream()
                .filter(iCar -> iCar.compareLocation(winner) == 0)
                .collect(Collectors.toSet()));
    }

    public Cars moveAll(Fuel fuel) {
        Set<Car> newList = new HashSet<>();
        for (Car iCar : this) {
            newList.add(
                    iCar.move(fuel)
            );
        }
        return new Cars(newList);
    }

    /* 단순 Forward 메소드들 (테스트 X) */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(values, cars.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}

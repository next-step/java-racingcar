package racing;

import racing.exception.CarNameMaximumLengthExceedException;
import racing.exception.DuplicatedCarException;
import racing.exception.RacingCarNotFoundException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars implements Iterable<Car> {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
        validate();
    }

    private void validate() {
        cars.forEach(this::validateLength);
        validateCarNameDuplicated();
    }

    private void validateCarNameDuplicated() {
        Set<String> collect = cars.stream().map(Car::getCarName).collect(Collectors.toSet());
        if (collect.size() < cars.size()) {
            throw new DuplicatedCarException("차 이름은 중복으로 지정할 수 없습니다.");
        }
    }

    private void validateLength(Car c) {
        if (c.getCarName().length() > 5) {
            throw new CarNameMaximumLengthExceedException(c.getCarName());
        }
    }

    public Car findCarByCarName(String carName) {
        return cars.stream().filter(c -> c.getCarName().equals(carName)).findFirst().orElseThrow(() -> new RacingCarNotFoundException(carName));
    }

    public Stream<Car> stream() {
        return cars.stream();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}

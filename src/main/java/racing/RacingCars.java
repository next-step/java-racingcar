package racing;

import racing.exception.CarNameMaximumLengthExceedException;
import racing.exception.RacingCarNotFoundException;

import java.util.Iterator;
import java.util.List;

public class RacingCars implements Iterable<Car> {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
        validate();
    }

    private void validate() {
        cars.forEach(this::validateLength);
    }

    private void validateLength(Car c) {
        if (c.getCarName().length() > 5) {
            throw new CarNameMaximumLengthExceedException(c.getCarName());
        }
    }

    public Car findCarByCarName(String carName) {
        return cars.stream().filter(c -> c.getCarName().equals(carName)).findFirst().orElseThrow(() -> new RacingCarNotFoundException(carName));
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}

package racing.vehicle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(int number) {
        validateNumber(number);
        cars = createRandomCars(number);
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("The number of participants must be positive.");
        }
    }

    private List<Car> createRandomCars(int number) {
        return IntStream.range(0, number)
                .mapToObj(i -> Car.createRandomCar())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Integer> getCarPositions() {
        return cars.stream().map(Car::getCurrentPosition).collect(Collectors.toList());
    }
}

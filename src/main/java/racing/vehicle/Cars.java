package racing.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(int number) {
        validateNumber(number);
        cars = new ArrayList<>();
        createRandomCars(number);
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("The number of participants must be positive.");
        }
    }

    private void createRandomCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(Car.createRandomCar());
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Integer> getCarPositions() {
        return cars.stream().map(Car::getCurrentPosition).collect(Collectors.toList());
    }
}

package racing.carRacing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    public static final int ZERO = 0;

    private final List<Car> cars;
    private final MovementStrategy movementStrategy;

    private Cars(List<Car> cars, MovementStrategy movementStrategy) {
        this.cars = cars;
        this.movementStrategy = movementStrategy;
    }

    public static Cars initCars(CarNames carNames, MovementStrategy movementStrategy) {
        List<Car> cars = IntStream.range(ZERO, carNames.numberOfCars())
                .mapToObj(carNames::matchCarName)
                .collect(Collectors.toList());

        return new Cars(cars, movementStrategy);
    }

    public void run() {
        cars.forEach(car -> car.run(movementStrategy));
    }

    public Car getCurrentCar(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }

    public String getWinner() {
        CarComparable carComparable = new CarComparable();
        cars.sort(carComparable);

        List<String> winner = cars.stream()
                .filter(car -> car.getCurrentPosition() == getMaxPosition())
                .map(Car::getCurrentCar)
                .collect(Collectors.toList());

        return String.join(", ", winner);
    }

    private int getMaxPosition() {
        return cars.get(0).getCurrentPosition();
    }
}

class CarComparable implements Comparator<Car> {
    @Override
    public int compare(Car first, Car second) {
        int firstPosition = first.getCurrentPosition();
        int secondPosition = second.getCurrentPosition();

        return Integer.compare(secondPosition, firstPosition);
    }
}
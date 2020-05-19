package step3.racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private int position;
    private final String name;
    private final MovingStrategy movingStrategy;

    public Car(String name, MovingStrategy movingStrategy) {
        this.position = DEFAULT_POSITION;
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() { return position; }

    public String getName() { return name; }

    public void move() {
        boolean isMovable = this.movingStrategy.isMovable();
        if (isMovable == true)
            this.position++;
    }

    public static List<Car> getWinnerCars(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Car> cars) {
        Car car = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new NoSuchElementException(Message.ERROR_MAX_POSITION));
        return car.getPosition();
    }
}

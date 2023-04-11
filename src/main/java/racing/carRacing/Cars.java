package racing.carRacing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final String DELIMITER = ",";

    private final List<Car> cars;
    private final MovementStrategy movementStrategy;

    private Cars(List<Car> cars, MovementStrategy movementStrategy) {
        this.cars = cars;
        this.movementStrategy = movementStrategy;
    }

    public static Cars initCars(String carNameString, MovementStrategy movementStrategy) {
        String[] splitName = carNameString.split(DELIMITER);

        hasCarName(splitName.length);

        List<Car> cars = initCarList(splitName);

        return new Cars(cars, movementStrategy);
    }

    private static List<Car> initCarList(String[] splitName) {
        return Arrays.stream(splitName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void hasCarName(int carNumber) {
        if (carNumber == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
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
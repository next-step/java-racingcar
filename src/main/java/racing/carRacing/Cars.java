package racing.carRacing;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    public static final int ZERO = 0;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initCars(String[] carNames) {
        hasCarName(carNames.length);

        List<Car> cars = initCarList(carNames);

        return new Cars(cars);
    }

    private static List<Car> initCarList(String[] splitName) {
        return Arrays.stream(splitName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void hasCarName(int numberOfCar) {
        if (numberOfCar == ZERO) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    public void run(MovementStrategy movementStrategy) {
        cars.forEach(car -> car.run(movementStrategy));
    }

    public Car getCurrentCar(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.equalsPosition(maxPosition))
                .map(Car::getCurrentCar)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .map(Car::getCurrentPosition)
                .get();
    }
}

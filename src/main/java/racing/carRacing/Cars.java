package racing.carRacing;

import java.util.Arrays;
import java.util.List;
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

    private static void hasCarName(int carNumber) {
        if (carNumber == ZERO) {
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
        return findWinners(getMaxPosition());
    }

    private List<String> findWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.equalsMaxPosition(maxPosition))
                .map(Car::getCurrentCar)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(ZERO);
    }
}

package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarManager {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public CarManager(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상 필요 합니다.");
        }

        validateUniqueCarName(cars);

        this.cars = new ArrayList<>(cars);
    }

    public static CarManager createCars(String names) {

        ArrayList<Car> cars = new ArrayList<>();

        String[] carNames = names.split(DELIMITER);

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return new CarManager(cars);
    }

    private void validateUniqueCarName(List<Car> cars) {
        Set<String> names = new HashSet<>();

        for (Car car : cars) {
            hasDuplicateNames(names, car.getName());
        }
    }


    private static void hasDuplicateNames(Set<String> names, String name) {
        if (!names.add(name)) {
            throw new IllegalArgumentException("차 이름 \"" + name + "\"이 중복되었습니다.");
        }
    }

    public List<Car> findWinner() {
        return findWinner(getMaxPosition());
    }

    private List<Car> findWinner(int maxPosition) {

        return cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            Position currentPosition = car.currentPosition();
            maxPosition = currentPosition.max(maxPosition);
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}

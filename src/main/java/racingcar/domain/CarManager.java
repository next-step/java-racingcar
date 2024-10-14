package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarManager {
    private final List<Car> cars;

    public CarManager(List<Car> cars) {
        validate(cars);

        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상 필요 합니다.");
        }

        validateUniqueCarName(cars);
    }

    private void validateUniqueCarName(List<Car> cars) {
        Set<String> names = new HashSet<>();

        for (Car car : cars) {
            hasDuplicateNames(names, car.getName());
        }
    }

    private void hasDuplicateNames(Set<String> names, String name) {
        if (!names.add(name)) {
            throw new IllegalArgumentException("차 이름 \"" + name + "\"이 중복되었습니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {

        WinnerFinder winnerFinder = new WinnerFinder(getMaxPosition(cars));

        return winnerFinder.findWinners(cars);
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }

        return maxPosition;
    }
}
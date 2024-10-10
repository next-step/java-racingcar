package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarManager {
    private final List<Car> cars;
    private List<String> winners = new ArrayList<>();


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

    public List<String> findWinner() {
        winners.clear();

        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.max(maxPosition);

            addWinner(car, maxPosition);
        }

        return winners;
    }

    private void addWinner(Car car, int maxPosition) {
        if(car.isWineer(maxPosition)){
            winners.add(car.getName());
        }
    }
}
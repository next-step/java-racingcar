package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNotEmpty(cars);
        validateNoDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private static void validateNotEmpty(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new RuntimeException("자동차는 한 대 이상이어야 합니다. (이름 목록이 비어 있습니다.)");
        }
    }

    private static void validateNoDuplicate(List<Car> cars) {
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new RuntimeException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static Cars fromNames(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public List<String> getWinners() {
        int max = findMaxPosition();
        List<Car> winningCars = findWinningCars(max);
        return extractCarNames(winningCars);
    }

    private List<String> extractCarNames(List<Car> winningCars) {
        List<String> names = new ArrayList<>();
        for (Car car : winningCars) {
            names.add(car.getName());
        }
        return names;
    }

    private List<Car> findWinningCars(int max) {
        List<Car> winningCars = new ArrayList<>(cars);
        winningCars.removeIf(car -> !car.isAt(max));
        return winningCars;
    }

    private int findMaxPosition() {
        return Collections.max(getPositions());
    }

    public void move(NumberGenerator generator) {
        for (Car car : cars) {
            car.tryMove(generator.create());
        }
    }

    public Map<String, Integer> getPositionsByName() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (Car car : cars) {
            positions.put(car.getName(), car.getPosition());
        }
        return positions;
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}

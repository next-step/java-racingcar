package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
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
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return Collections.max(positions);
    }
}

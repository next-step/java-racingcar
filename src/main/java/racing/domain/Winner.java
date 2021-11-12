package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Winner {

    private List<Car> cars = new ArrayList<>();
    private Map<Integer, List<Car>> history = new HashMap<>();

    public Map<Integer, List<Car>> getHistory() {
        return history;
    }

    public void addHistory(Integer i, List<Car> car) {
        this.history.put(i, car);
    }

    public void addCars(List<Car> winners) {
        this.cars = winners;
    }

    public List<Car> getWinners() {
        int max = getMaxStep();

        return this.cars.stream()
            .filter(c -> c.hasEqualTo(max))
            .collect(Collectors.toList());
    }

    private int getMaxStep() {
        return this.cars.stream()
            .mapToInt(Car::getStep)
            .max()
            .orElseThrow(NoSuchElementException::new);
    }
}

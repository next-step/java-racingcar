package racing.domain;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Winner {

    private List<Car> cars;
    private Map<Integer, List<Car>> history;

    private Winner(List<Car> cars, Map<Integer, List<Car>> history) {
        this.cars = cars;
        this.history = history;
    }

    public static Winner from(List<Car> cars, Map<Integer, List<Car>> history) {
       return new Winner(cars, history);
    }

    public Map<Integer, List<Car>> getHistory() {
        return history;
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

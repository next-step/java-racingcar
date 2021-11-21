package racing.model;

import java.util.List;

/**
 * .
 */
public class RoundResult {

    private final Cars cars;

    public RoundResult(List<Car> cars) {
        this.cars = new Cars(cars);
    }

    public List<Car> records() {
        return cars.getCars();
    }

    @Override
    public String toString() {
        return "RoundResult{" +
                "cars=" + cars +
                '}';
    }
}

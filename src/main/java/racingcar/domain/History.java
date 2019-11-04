package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History {

    private List<Cars> carsHistory;

    History() {
        this.carsHistory = new ArrayList<>();
    }

    void add(Cars cars) {
        List<Car> carsInRacing = cars.get();
        List<Car> carsForHistory = new ArrayList<>();
        for (Car car : carsInRacing) {
            carsForHistory.add(Car.valueOf(car));
        }
        this.carsHistory.add(Cars.valueOf(carsForHistory));
    }

    public int size() {
        return this.carsHistory.size();
    }

    public Cars get(final int index) {
        return this.carsHistory.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(carsHistory, history.carsHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsHistory);
    }
}

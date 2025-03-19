package racing;

import java.util.List;

public class Report {

    private final List<Car> cars;

    public Report(List<Car> cars) {
        this.cars = cars;
    }

    public Integer findPositionByIndex(Integer index) {
        if (index < 0 || index >= cars.size()) {
            throw new IllegalArgumentException("Not valid index");
        }

        return cars.get(index).getPosition();
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History {

    private List<List<Car>> carsHistory;

    History() {
        this.carsHistory = new ArrayList<>();
    }

    void add(List<Car> cars) {
        this.carsHistory.add(cars);
    }

    public int size() {
        return this.carsHistory.size();
    }

    public List<Car> get(final int index) {
        return Collections.unmodifiableList(this.carsHistory.get(index));
    }


}

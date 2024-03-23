package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> cars;

    public Winners() {
        this(new ArrayList<>());
    }

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> winners() {
        return this.cars;
    }

    public void addWinner(Car winner) {
        this.cars.add(winner);
    }
}

package step3.game.domain;

import java.util.List;

public class Winners {
    private final List<Car> cars;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getNumberOfWinners() {
        return cars.size();
    }
}

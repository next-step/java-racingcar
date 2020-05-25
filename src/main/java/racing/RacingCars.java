package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carPositions;

    public RacingCars(int cars) {
        this.carPositions = prepareCars(cars);
    }

    public List<Car> prepareCars(int cars) {
        List<Car> carsPositions = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            carsPositions.add(new Car());
        }
        return carsPositions;
    }

    public List<Car> moveCars() {
        for (int i = 0; i < carPositions.size(); i++) {
            carPositions.get(i).move(new CarForwardBehavior());
        }
        return carPositions;
    }

    public List<Car> getCars() {
        return carPositions;
    }
}

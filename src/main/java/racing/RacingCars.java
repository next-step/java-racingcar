package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private int cars;

    public RacingCars(int cars) {
        this.cars = cars;
    }

    public List<Car> prepareCars() {
        List<Car> carsPositions = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            carsPositions.add(new Car());
        }
        return carsPositions;
    }
}

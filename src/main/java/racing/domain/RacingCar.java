package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final List<Car> carList;

    public RacingCar() {
        this.carList = new ArrayList<>();
    }

    public RacingCar(int carCount) {
        this();
        joinCars(carCount);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private void joinCars(int carCount) {
        for (int i = 0 ; i < carCount ; i++) {
            carList.add(new Car());
        }
    }
}

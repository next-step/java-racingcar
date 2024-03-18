package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<Car> carList;

    public RacingCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(new Location(0)));
        }
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}

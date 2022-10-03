package step3.car_racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars(Integer carSize) {
        for (int i = 0; i < carSize; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}

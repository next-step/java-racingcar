package step3.car_racing.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public Cars makeCarList(Integer listSize) {

        for (int i = 0; i < listSize; i++) {
            this.carList.add(new Car());
        }

        return this;
    }

    public List<Car> getCarList() {
        return carList;
    }
}

package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(int numberOfCar) {
        List<Car> list = createCarList(numberOfCar);
        this.carList = list;
    }

    private List<Car> createCarList(int numberOfCar) {
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            list.add(new Car());
        }
        return list;
    }

    public List<Car> getCarList() {
        return carList;
    }
}

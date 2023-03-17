package car.domain;

import java.util.List;

public class CarList {

    private final List<Car> carNameList;

    public CarList(List<Car> carNameList) {
        this.carNameList = carNameList;
    }

    public List<Car> getCarNameList() {
        return carNameList;
    }
}

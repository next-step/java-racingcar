package step3;

import java.util.List;

public class CarList {

    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getCar(int idx) {
        return carList.get(idx);
    }
}

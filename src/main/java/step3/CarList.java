package step3;

import java.util.List;

public class CarList {

    private List<Car> carList;

    private CarList(List<Car> carList) {
        this.carList = carList;
    }

    public static CarList from(List<Car> carList) {
        return new CarList(carList);
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}

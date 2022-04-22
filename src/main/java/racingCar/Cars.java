package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public Cars(int countOfCar) {
        for (int i =0; i < countOfCar; i++) {
            Car car = new Car();
            this.carList.add(car);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}

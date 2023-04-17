package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCompany {
    public List<Car> createCar(int carNum) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            Car car = new Car();
            cars.add(car);
        }
        return cars;
    }
}

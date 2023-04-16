package carRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCompany {
    public ArrayList createCar(int carNum) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            Car car = new Car();
            cars.add(car);
        }
        return cars;
    }
}

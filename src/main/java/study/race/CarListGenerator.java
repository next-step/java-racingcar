package study.race;

import java.util.ArrayList;
import java.util.List;

public class CarListGenerator {

    private int numberOfCar;

    public CarListGenerator(int numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public List<Car> generateCarList() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < this.numberOfCar; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

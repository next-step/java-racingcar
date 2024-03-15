package race.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Car> createCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i=0; i<carCount; i++) {
            carList.add(new Car(0));
        }
        return carList;
    }
}

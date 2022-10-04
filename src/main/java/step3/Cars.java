package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList = new ArrayList<>();

    public List<Car> Cars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            carList.add(new Car());
        }
        return carList;
    }
}

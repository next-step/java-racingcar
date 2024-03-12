package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(int numberOfCars) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}

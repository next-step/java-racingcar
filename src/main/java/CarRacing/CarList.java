package CarRacing;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList = new ArrayList<Car>();

    public void addCarCount(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}

package racinggame;

import java.util.ArrayList;
import java.util.List;

public class CarLists {
    private List<Car> carList;

    public CarLists(int carQuantity) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car());
        }
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}

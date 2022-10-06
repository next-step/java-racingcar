package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.AdvanceConstant.ADVANCE_STRING;

public class CarAddFactory {
    private final List<Car> carList;

    public CarAddFactory() {
        this.carList = new ArrayList<>();
    }

    public List<Car> addCarsToList(int carQuantity) {
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car(ADVANCE_STRING));
        }
        return carList;
    }
}

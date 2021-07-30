package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private List<Car> carList;

    public CarRacing(int carCount) {
        this.carList = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> racing() {
        for (Car car : carList) {
            car.moveForward();
        }
        return carList;
    }
}

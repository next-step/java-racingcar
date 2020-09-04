package mission1.step3.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCarList(int carNumber) {
            if (carNumber < 1) {
                throw new IllegalArgumentException("createCarList의 인자값은 최소 1 이상이어야 합니다.");
            }

            List<Car> carList = new ArrayList<>();

            for (int i = 0; i < carNumber; i++) {
                carList.add(Car.createCar());
            }

            return carList;
    }
}

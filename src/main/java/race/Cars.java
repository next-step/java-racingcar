package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final List<Car> carList = new ArrayList<>();

    private Cars() {
    }

    public static Cars createCarList(int carCount) {
        for (int i = carCount; i > 0; i--) {
            Car car = new Car();
            carList.add(car);
        }
        return new Cars();
    }

    protected final List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    protected Cars moveCars(Cars carList, MoveCondition moveCondition) {
        for (Car car: carList.getCarList()) {
            car.addDistance(moveCondition);
        }
        return carList;
    }

}

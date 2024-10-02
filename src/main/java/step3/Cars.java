package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Car> cars) {
        this.carList = new ArrayList<>(cars);
    }

    public void moveAll(CarEngine carEngine) {
        for (Car car : carList) {
            car.move(carEngine);
        }
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

}

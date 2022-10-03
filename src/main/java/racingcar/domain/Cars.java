package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public Cars move(Generator generator) {
        List<Car> moveCars = new ArrayList<>();
        for (Car car : carList) {
            moveCars.add(car.move(generator));
        }
        return new Cars(moveCars);
    }

    public List<Car> getCarList() {
        return carList;
    }
}

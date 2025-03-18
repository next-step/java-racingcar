package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars generateCars(int numOfCars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numOfCars ; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public void move() {
        for (Car car: carList) {
            car.move();
        }
    }

}

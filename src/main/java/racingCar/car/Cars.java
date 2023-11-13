package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    private Cars() {
    }

    public static Cars of(int carCount) {
        Cars cars = new Cars();
        cars.addCar(carCount);
        return cars;
    }

    public List<Car> carList() {
        return carList;
    }

    public void addCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
    }

    public void moveOnce() {
        for (Car car : carList) {
            car.move(RacingUtil.getRandomNumber());
        }
    }
}

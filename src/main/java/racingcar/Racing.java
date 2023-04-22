package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private int carNum;
    private List<Car> cars;
    private MovingStrategy movingStrategy;

    public Racing(int carNum, List<Car> cars, MovingStrategy movingStrategy) {
        this.carNum = carNum;
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static List<Car> create(int carNum) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getRacingCars() {
        return cars;
    }
}

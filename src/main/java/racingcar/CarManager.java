package racingcar;

import racingcar.strategy.IMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarManager {

    public static List<Car> prepareCar(int carCount) {
        if (carCount <=  0) {
            throw new RuntimeException("자동차 개수는 0 이상이어야 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

    public static void moveCars(List<Car> cars, IMoveStrategy moveStrategy) {
        for (Car car : cars) {
            moveCar(car, moveStrategy);
        }
    }

    private static void moveCar(Car car, IMoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            car.move();
        }
    }

}

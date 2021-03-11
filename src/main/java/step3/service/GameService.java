package step3.service;

import step3.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    static MoveStrategy moveStrategy = new MoveStrategy();

    public static void runStep(List<Car> cars) {
        for (Car car : cars) {
            Integer getRandomNum = moveStrategy.generateRandomNumber();
            Boolean isMove = moveStrategy.getIsMove(getRandomNum);
            car.moveCar(isMove);
        }
    }

    public List<Car> generateCar(Integer carNumber) {
        List<Car> cars = new ArrayList<>();
        for (Integer i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}

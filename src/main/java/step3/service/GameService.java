package step3.service;

import step3.domain.Car;

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
}

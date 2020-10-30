package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {


    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(int carCount , MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        cars = new Cars(carList);
    }


    public Cars getGameRoundResult() {
        cars.moveCars(moveStrategy);
        return cars;
    }
}

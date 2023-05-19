package study.step3;

import study.step3.domain.Car;
import study.step3.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> carList = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public RacingGame(int carNum, MoveStrategy moveStrategy){
        this.moveStrategy = moveStrategy;
        for (int i = 0; i < carNum; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void play() {
        for (Car car : carList) {
            if (moveStrategy.isSuccess()) {
                car.move();
            }
        }
    }
}

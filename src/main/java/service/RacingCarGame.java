package service;

import dto.CarInfo;
import model.Cars;
import model.MoveCount;

import java.util.List;

public class RacingCarGame {

    private final Cars cars;
    private final MoveCount moveCount;

    public RacingCarGame(String carNames, MoveCount moveCount) {
        this.cars = new Cars(carNames);
        this.moveCount = moveCount;
    }

    public void race() {
        moveCount.decreaseMoveCount();
        cars.moveCars();
    }

    public boolean isDone() {
        return moveCount.isDone();
    }

    public List<CarInfo> getCarsInfo() {
        return cars.getCarsInfo();
    }
}

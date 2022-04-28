package service;

import dto.CarWinnerDto;
import model.Cars;
import model.MoveCount;
import model.RoundHistory;

import java.util.ArrayList;
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

    public List<RoundHistory> race(Cars cars, MoveCount moveCount) {
        List<RoundHistory> roundHistories = new ArrayList<>();

        while (!moveCount.isDone()) {
            moveCount.decreaseMoveCount();
            cars.moveCars();
            roundHistories.add(new RoundHistory(cars.getMoveHistories()));
        }

        return roundHistories;
    }


    public List<CarWinnerDto> getCarWinner() {
        return cars.getWinnerCars();
    }

}

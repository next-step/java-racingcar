package study.step4.service;

import study.step4.controller.CarsPositionModel;
import study.step4.domain.Cars;
import study.step4.domain.strategy.MoveStrategy;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private GameCount gameCount;

    public RacingGame(Cars cars, GameCount gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public List<CarsPositionModel> play(MoveStrategy moveStrategy) {
        cars.move(moveStrategy);

        return cars.toCarsPositionModel();
    }

    public boolean isPlay() {
        if(gameCount.isTerminated())
            return false;

        gameCount.consume();

        return true;
    }

    public List<String> winners() {
        return cars.winners();
    }
}

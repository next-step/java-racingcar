package study.step4.service;

import study.step4.controller.CarsPositionModel;
import study.step4.domain.Cars;
import study.step4.domain.strategy.MoveStrategy;

import java.util.List;

public class RacingGame {
    private static final int GAME_TERMINATED_COUNT = 0;
    private Cars cars;
    private int gameCount;

    public RacingGame(Cars cars, int gameCount) {
        this.cars = cars;
        this.gameCount = gameCount;
    }

    public List<CarsPositionModel> play(MoveStrategy moveStrategy) {
        cars.move(moveStrategy);

        return cars.toCarsPositionModel();
    }

    public boolean isPlay() {
        if(gameCount == GAME_TERMINATED_COUNT)
            return false;

        gameCount--;

        return true;
    }

    public List<String> winners() {
        return cars.winners();
    }
}

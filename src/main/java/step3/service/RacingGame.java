package step3.service;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.MoveStrategy;
import step3.dto.RacingGameDTO;
import step3.exception.MinimumTryCountException;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {


    private static final int MIN_TRY_COUNT = 1;
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public RacingGame(RacingGameDTO racingGameDTO, MoveStrategy moveStrategy) {
        validTryCount(racingGameDTO.getTryCount());
        this.moveStrategy = moveStrategy;
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < racingGameDTO.getCarCount(); i++) {
            carList.add(new Car());
        }
        cars = new Cars(carList);
    }


    public Cars getGameRoundResult() {
        cars.moveCars(moveStrategy);
        return cars;
    }
    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException();
        }

    }
}

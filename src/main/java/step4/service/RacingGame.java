package step4.service;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.MoveStrategy;
import step4.dto.RacingGameCondition;
import step4.exception.MinimumTryCountException;
import step4.exception.OutBoundCarListSizeException;
import step4.utils.CarNameSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {


    private static final int MIN_TRY_COUNT = 1;
    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final RacingGameCondition racingGameCondition;

    public RacingGame(RacingGameCondition racingGameCondition, MoveStrategy moveStrategy) {
        this.racingGameCondition = racingGameCondition;
        this.moveStrategy = moveStrategy;

        validTryCount(getRacingGameTryCount());
        String[] carNames = CarNameSplitter.splitter(getRacingGameCarNames());
        validCarCount(carNames);
        List<Car> carList = Arrays.stream(carNames)
                .map(Car::new).collect(Collectors.toList());
        cars = new Cars(carList);
    }

    private void validCarCount(String[] carNames) {
        if(carNames.length < 1){
            throw new OutBoundCarListSizeException();
        }
    }

    public int getRacingGameTryCount() {
        return this.racingGameCondition.getTryCount();
    }

    private String getRacingGameCarNames() {
        return this.racingGameCondition.getCarNames();
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

package step4.service;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.MoveStrategy;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.exception.MinimumTryCountException;
import step4.exception.OutBoundCarListSizeException;
import step4.utils.CarNameSplitter;

import java.util.List;


public class RacingGame {


    private static final int MIN_TRY_COUNT = 1;
    private static final int CARS_MIN_COUNT = 1;
    private final Cars cars;
    private final RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO;

    public RacingGame(RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO) {
        this.racingGameConditionMoveStrategyDTO = racingGameConditionMoveStrategyDTO;

        validTryCount(getRacingGameTryCount());
        List<Car> carList = CarNameSplitter.splitToCarList(getRacingGameCarNames());
        validateCarSize(carList);
        cars = new Cars(carList);
    }


    public int getRacingGameTryCount() {
        return racingGameConditionMoveStrategyDTO
                .getRacingGameConditionDTO()
                .getTryCount();
    }

    public String getRacingGameCarNames() {
        return racingGameConditionMoveStrategyDTO
                .getRacingGameConditionDTO()
                .getCarNames();
    }


    public Cars getGameRoundResult() {
        cars.moveCars(getGameMoveStrategy());
        return cars;
    }

    private MoveStrategy getGameMoveStrategy() {
        return racingGameConditionMoveStrategyDTO.getMoveStrategy();
    }

    public Cars getGameEndResult() {
        return cars;
    }

    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException(MIN_TRY_COUNT);
        }

    }

    private void validateCarSize(List<Car> cars) {
        if (cars.size() < CARS_MIN_COUNT) {
            throw new OutBoundCarListSizeException(CARS_MIN_COUNT);
        }
    }
}

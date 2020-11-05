package step4.service;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.MoveStrategy;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.exception.MinimumTryCountException;
import step4.utils.CarNameSplitter;

import java.util.List;


public class RacingGame {


    private static final int MIN_TRY_COUNT = 1;
    private final Cars cars;
    private final RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO;

    private RacingGame(RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO) {
        this.racingGameConditionMoveStrategyDTO = racingGameConditionMoveStrategyDTO;
        validTryCount(getRacingGameTryCount());
        List<Car> carList = CarNameSplitter.splitToCarList(getRacingGameCarNames());
        cars = new Cars(carList);
    }

    public static RacingGame of(RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO) {
        return new RacingGame(racingGameConditionMoveStrategyDTO);
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

    public Cars getGameEndResult() {
        return cars;
    }

    private MoveStrategy getGameMoveStrategy() {
        return racingGameConditionMoveStrategyDTO.getMoveStrategy();
    }


    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException(MIN_TRY_COUNT);
        }

    }


}

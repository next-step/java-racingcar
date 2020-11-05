package step4.service;

import step4.domain.Car;
import step4.domain.Cars;
import step4.domain.GameRound;
import step4.domain.MoveStrategy;
import step4.dto.RacingGameConditionMoveStrategyDTO;
import step4.exception.MinimumTryCountException;
import step4.exception.NotGameEndException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class RacingGame {


    private static final String SPLIT_SEPARATOR = ",";
    private static final String WINNER_DELIMITER = ",";
    private static final int MIN_TRY_COUNT = 1;
    private final Cars cars;
    private final RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO;
    private final GameRound gameRound;

    private RacingGame(RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO) {
        this.racingGameConditionMoveStrategyDTO = racingGameConditionMoveStrategyDTO;
        validTryCount(getRacingGameTryCount());
        gameRound = GameRound.of(racingGameConditionMoveStrategyDTO.getRacingGameConditionDTO().getTryCount());
        cars = new Cars(splitToCarList(getRacingGameCarNames()));
    }

    public static RacingGame of(RacingGameConditionMoveStrategyDTO racingGameConditionMoveStrategyDTO) {
        return new RacingGame(racingGameConditionMoveStrategyDTO);
    }

    public Cars getGameRoundResult() {
        gameRound.stackGameRound();
        cars.moveCars(getGameMoveStrategy());
        return cars;
    }

    public String getTopPositionCarNames() {
        validGameEnd();
        int topPosition = getTopPosition(cars.getCarList());
        return cars.getCarList().stream()
                .filter(car -> car.getPosition() == topPosition)
                .map(Car::toString)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void validGameEnd() {
        if (!gameRound.isGameFinish()) {
            throw new NotGameEndException();
        }
    }

    private MoveStrategy getGameMoveStrategy() {
        return racingGameConditionMoveStrategyDTO.getMoveStrategy();
    }


    private void validTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new MinimumTryCountException(MIN_TRY_COUNT);
        }

    }

    private List<Car> splitToCarList(String input) {
        return Arrays.stream(input.split(SPLIT_SEPARATOR))
                .map(Car::new).collect(Collectors.toList());
    }


    private static Integer getTopPosition(List<Car> carList) {
        return carList.stream()
                .map(v -> v.getPosition())
                .max(Integer::compare)
                .get();
    }

    private int getRacingGameTryCount() {
        return racingGameConditionMoveStrategyDTO
                .getRacingGameConditionDTO()
                .getTryCount();
    }

    private String getRacingGameCarNames() {
        return racingGameConditionMoveStrategyDTO
                .getRacingGameConditionDTO()
                .getCarNames();
    }


}

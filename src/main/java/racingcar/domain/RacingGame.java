package racingcar.domain;

import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingGame {
    public GameResultDto doGame(List<String> carNames, int trial)
            throws IllegalArgumentException, NoSuchElementException {
        Cars cars = Cars.namesOf(carNames);
        GameResultDto gameResultDto = new GameResultDto();
        for (int i = 0; i < trial; i++) {
            cars.race();
            gameResultDto.recordRoundResults(cars);
        }
        gameResultDto.recordWinnerNames(cars.getWinnerNames());
        return gameResultDto;
    }
}

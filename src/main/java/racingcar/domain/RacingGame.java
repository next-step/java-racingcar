package racingcar.domain;

import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingGame {

    private final GameResultDto gameResultDto = new GameResultDto();

    private Cars cars = null;

    public void startGame(List<String> carNames, int trial) throws IllegalArgumentException, NoSuchElementException {
        cars = Cars.namesOf(carNames);
        for (int i = 0; i < trial; i++) {
            cars.race();
            gameResultDto.recordResults(cars);
        }
    }

    public GameResultDto getRoundResults() {
        return gameResultDto;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}

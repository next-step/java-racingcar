package racingcar.domain;

import racingcar.dto.GameResultDto;

import java.util.List;
import java.util.NoSuchElementException;

public class RacingGame {

    private Cars cars = null;

    public GameResultDto startGame(List<String> carNames, int trial) throws IllegalArgumentException {
        cars = Cars.namesOf(carNames);
        GameResultDto gameResultDto = new GameResultDto();
        for (int i = 0; i < trial; i++) {
            cars.race();
            gameResultDto.recordResults(cars);
        }
        return gameResultDto;
    }

    public List<String> getWinners() throws NoSuchElementException {
        return cars.getWinners();
    }
}

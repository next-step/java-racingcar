package racingcar.domain;

import racingcar.dto.GameResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingGame {
    private static final int MOVABLE_THRESHOLD = 4;

    private final GameResultDto gameResultDto = new GameResultDto();

    private List<String> winners = new ArrayList<>();

    public void startGame(List<String> carNames, int trial) throws IllegalArgumentException, NoSuchElementException {
        Cars cars = Cars.namesOf(carNames);
        for (int i = 0; i < trial; i++) {
            cars.race(MOVABLE_THRESHOLD);
            gameResultDto.recordResults(cars);
        }
        winners = cars.getWinners();
    }

    public GameResultDto getRoundResults() {
        return gameResultDto;
    }

    public List<String> getWinners() {
        return winners;
    }
}

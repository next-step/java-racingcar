package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingGame {
    private static final int MOVABLE_THRESHOLD = 4;

    private final RoundResults roundResults = new RoundResults();

    private List<String> winners = new ArrayList<>();

    public void startGame(List<String> carNames, int trial) throws IllegalArgumentException, NoSuchElementException {
        Cars cars = Cars.namesOf(carNames);
        for (int i = 0; i < trial; i++) {
            cars.race(MOVABLE_THRESHOLD);
            roundResults.recordResults(cars);
        }
        winners = cars.getWinners();
    }

    public List<List<CarResultDto>> getRoundResults() {
        return roundResults.getResults();
    }

    public List<String> getWinners() {
        return winners;
    }
}

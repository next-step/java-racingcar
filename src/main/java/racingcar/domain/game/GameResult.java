package racingcar.domain.game;

import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

import java.util.*;

public class GameResult {

    private final List<Car> winners = new ArrayList();;
    private final List<String> roundResults = new ArrayList();
    private final WinnerGetter winnerGetter = new WinnerGetter();

    public void addRoundResult(List<String> result) {
        roundResults.addAll(result);
    }

    public void addWinnersResult(Cars cars) {
        winners.addAll(winnerGetter.getWinnerCars(cars));
    }

    public List<String> getRoundResults() {
        return Collections.unmodifiableList(this.roundResults);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(this.winners);
    }
}
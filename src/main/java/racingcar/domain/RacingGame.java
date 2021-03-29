package racingcar.domain;

import racingcar.dto.Round;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int roundCount;
    private Winners winners;

    public RacingGame(List<String> carNames, int roundCount) {
        this.cars = Cars.of(initializeCars(carNames));
        this.roundCount = roundCount;
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(Car.create(carName));
        }
        return carList;
    }

    public List<Round> runGame(MoveStrategy strategy) {
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            cars.runRound(strategy);
            rounds.add(new Round(cars));
        }
        findWinners();
        return rounds;
    }
    private void findWinners() {
        this.winners = cars.getWinners();
    }

    public String winnersList() {
        return winners.winnersToString();
    }
}

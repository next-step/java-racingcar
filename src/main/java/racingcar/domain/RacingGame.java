package racingcar.domain;

import racingcar.dto.Round;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public Cars cars;
    public int roundCount;

    public RacingGame(List<String> carNames, int roundCount) {
        this.cars = Cars.of(initializeCars(carNames));
        this.roundCount = roundCount;
    }

    private List<Car> initializeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public List<Round> runGame(MoveStrategy strategy) {
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            cars = cars.runRound(strategy);
            rounds.add(new Round(cars));
        }
        return rounds;
    }

}

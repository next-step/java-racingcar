package study.racing.domain;

import study.racing.domain.move.RandomMoveStrategy;

import java.util.List;

import static study.racing.view.ResultView.*;

public class Game {

    private final Cars cars;
    private final RoundCount roundCount;

    public Game(Cars cars, int roundCount) {
        this.cars = cars;
        this.roundCount = new RoundCount(roundCount);
    }

    public void playGame() {
        this.roundCount.executeRounds(() -> {
            playRound(this.cars.getCars());
            printEmptyLine();
        });
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(new RandomMoveStrategy());
            printGameRound(car);
        }
    }

    public Cars getCars() {
        return cars;
    }

}

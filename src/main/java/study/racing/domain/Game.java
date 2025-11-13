package study.racing.domain;

import java.util.List;

import static study.racing.view.ResultView.*;

public class Game {

    private final Cars cars;
    private final int roundCount;

    public Game(List<String> names, int roundCount) {
        this.cars = new Cars(names);
        this.roundCount = roundCount;
    }

    public void playGame() {
        for (int i = 0; i < this.roundCount; i++) {
            List<Car> cars = this.cars.getCars();
            playRound(cars);
            printEmptyLine();
        }
    }

    private static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            printGameRound(car);
        }
    }

    public Cars getCars() {
        return cars;
    }

    public int getRoundCount() {
        return roundCount;
    }
}

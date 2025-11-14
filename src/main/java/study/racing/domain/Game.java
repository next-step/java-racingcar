package study.racing.domain;

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
        for (int i = 0; i < this.roundCount.value(); i++) {
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

}

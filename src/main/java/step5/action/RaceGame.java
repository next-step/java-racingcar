package step5.action;

import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.strategy.ArrangeStrategy;
import step5.domain.strategy.MoveStrategy;
import step5.domain.strategy.RandomNumberMoveStrategy;
import step5.domain.strategy.WinnerStrategy;

import java.util.List;

public class RaceGame {
    // Setting Value
    private static final int MOVE_BOUNDARY = 4;
    private static final int RANDOM_BOUNDARY = 10;

    private final Cars cars;
    private MoveStrategy strategy = new RandomNumberMoveStrategy(MOVE_BOUNDARY,RANDOM_BOUNDARY);

    private RaceGame(Cars cars) {
        this.cars = cars;
    }

    public static RaceGame of(Cars cars) {
        return new RaceGame(cars);
    }

    public Cars getCars() {
        return cars;
    }

    public void move() {
        cars.move(strategy);
    }

    public List<Car> getWinner(WinnerStrategy winnerStrategy, ArrangeStrategy arrangeStrategy) {
        List<Car> carList = cars.arrangeList(arrangeStrategy);
        return winnerStrategy.getWinner(carList);
    }
}

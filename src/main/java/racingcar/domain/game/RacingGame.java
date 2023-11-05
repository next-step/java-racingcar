package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.strategy.MoveStrategy;
import racingcar.domain.game.strategy.RandomMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final GameInfo gameInfo;
    private final MoveStrategy moveStrategy;
    private final Cars cars;

    public RacingGame(int carCount, int totalGameCount) {
        this.gameInfo = new GameInfo(carCount, totalGameCount);
        this.moveStrategy = new RandomMoveStrategy();
        this.cars = createCars();
    }

    public void startRacing() {
        this.cars.move(this.moveStrategy);
        this.gameInfo.increaseGameRound();
    }

    public boolean isEndGame() {
        return this.gameInfo.isEndGame();
    }

    public Cars getCars() {
        return this.cars;
    }

    private Cars createCars() {
        List<Car> carList = Stream.generate(Car::new)
                .limit(this.gameInfo.getCarCount())
                .collect(Collectors.toList());

        return new Cars(carList);
    }
}

package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.game.strategy.MoveStrategy;
import racingcar.domain.game.strategy.RandomMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private final RoundInfo roundInfo;
    private final MoveStrategy moveStrategy;
    private final Cars cars;

    public RacingGame(int carCount, int totalGameCount) {
        this.roundInfo = new RoundInfo(totalGameCount);
        this.moveStrategy = new RandomMoveStrategy();
        this.cars = createCars(carCount);
    }

    public void startRacing() {
        this.cars.move(this.moveStrategy);
        this.roundInfo.increaseRound();
    }

    public boolean isEndGame() {
        return this.roundInfo.isEndGame();
    }

    public Cars getCars() {
        return this.cars;
    }

    private Cars createCars(int carCount) {
        validateCarCount(carCount);

        List<Car> carList = Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());

        return new Cars(carList);
    }

    private void validateCarCount(int carCount) {
        if (carCount <= 0) {
            throw new IllegalArgumentException("최소 1개 이상의 자동차를 만들어야합니다.");
        }
    }
}

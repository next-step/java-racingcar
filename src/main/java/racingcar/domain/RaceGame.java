package racingcar.domain;

import java.util.List;

public class RaceGame {

    private final Cars cars;
    private final GameRound gameRound;

    public RaceGame(List<Car> cars, int tryCount) {
        this(cars,new GameRound(tryCount));
    }

    public RaceGame(List<Car> cars, GameRound gameRound) {
        this.cars = new Cars(cars);
        this.gameRound = gameRound;
    }

    public void moveCars(final MoveStrategy moveStrategy) {
        for (Car car : cars.getCars()) {
            gameRound.increase();
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<String> getWinnersName() {
        return cars.getFarthestCarNames();
    }
}

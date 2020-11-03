package racingcar.game;

import racingcar.car.Car;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final GameHistory gameHistory = new GameHistory();
    public void addCar(Car car) {
        cars.add(car);
    }

    private void logGameHistory(int round){
        Map<String, Integer> history = new HashMap<>();
        cars.forEach(car-> history.put(car.getName(), car.currentProgress()));
        gameHistory.addHistory(round, history);
    }

    public void notifyCars(int round) {
        cars.forEach(Car::go);
        logGameHistory(round);
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    public abstract void addCarList(int number, MoveStrategy moveStrategy);
    public abstract void addCarList(List<String> carNames, MoveStrategy moveStrategy);

    public abstract void execute(RacingInfomation racingInfomation, MoveStrategy moveStrategy);
}

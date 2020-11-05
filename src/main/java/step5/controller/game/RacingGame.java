package step5.controller.game;

import step5.domain.dto.RacingInfomation;
import step5.domain.model.car.Car;
import step5.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final GameHistory gameHistory = new GameHistory();
    public void appendCar(Car car) {
        cars.add(car);
    }

    private void logGameHistory(int round){
        Map<String, Integer> history = new HashMap<>();
        cars.forEach(car-> history.put(car.getName(), car.currentProgress()));
        gameHistory.appendHistory(round, history);
    }

    public void notifyCars(int round, MoveStrategy strategy) {
        cars.forEach(car -> car.go(strategy));
        logGameHistory(round);
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    public abstract void appendCarList(List<String> carNames);

    public abstract void play(RacingInfomation racingInfomation, MoveStrategy moveStrategy);
}
